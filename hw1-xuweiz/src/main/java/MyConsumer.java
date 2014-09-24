import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;

import mypackage.MyTypeSystem;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.collection.CasConsumer_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.ResourceProcessException;
import org.xml.sax.SAXException;

public class MyConsumer extends CasConsumer_ImplBase {
  public static final String PARAM_OUTPUTDIR = "OutputDirectory";

  public static final String PARAM_OUTPUTNAME = "OutputFileName";

  private File mOutputDir;

  private String mOutputName;
/**
 * Load parameters "OutputDirectory" and "OutputFileName" from linked Consumer descriptor 
 * as output directory and filename from .
 * Initialize output directory and output file.
 */
  public void initialize() throws ResourceInitializationException {
    mOutputName = (String) getConfigParameterValue(PARAM_OUTPUTNAME);
    mOutputDir = new File((String) getConfigParameterValue(PARAM_OUTPUTDIR));
    if (!mOutputDir.exists()) {
      mOutputDir.mkdirs();
    }
    PrintWriter writer = null;
    try {
      writer = new PrintWriter(new File(mOutputDir,mOutputName));
      writer.print("");
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    finally{
      try {
        writer.close();
      } catch (Exception ex) {
      }
    }
  }
/**
 * Receive CAS from AE. Exclude the whitespace offset and output the results to the given directory.
 */
  @Override
  public void processCas(CAS aCAS) throws ResourceProcessException {
    // TODO Auto-generated method stub
    // String modelFileName = null;

    JCas jcas;
    try {
      jcas = aCAS.getJCas();
    } catch (CASException e) {
      throw new ResourceProcessException(e);
    }
    FSIterator it = jcas.getAnnotationIndex(MyTypeSystem.type).iterator();
    // String outFileName = "sample.out";
    String sent = jcas.getDocumentText();
    File outFile = new File(mOutputDir, mOutputName);

    while (it.hasNext()) {
      MyTypeSystem mts = (MyTypeSystem) it.next();
      int start = mts.getStart();
      int end = mts.getEnd();
      int ws = 0;
      String subs = sent.substring(0, start);
      for (char c : subs.toCharArray()) {
        if (c == ' ') {
          ws++;
        }
      }
      int wss = ws;
      subs = sent.substring(start, end);
      for (char c : subs.toCharArray()) {
        if (c == ' ') {
          ws++;
        }
      }
      ws++;
      start -= wss;
      end -= ws;

      String str = mts.getMark() + "|" + start+ " " + end + "|" + mts.getGene()
              + "\n";
      // serialize XCAS and write to output file
      FileWriter writer = null;
      BufferedWriter bw = null;
      try {
        writer = new FileWriter(outFile, true);
        bw = new BufferedWriter(writer);
        bw.append(str);

      } catch (IOException e) {
        throw new ResourceProcessException(e);
      } finally {
        try {
          bw.close();
        } catch (Exception ex) {
        }
        try {
          writer.close();
        } catch (Exception ex) {
        }

      }
    }
  }

}
