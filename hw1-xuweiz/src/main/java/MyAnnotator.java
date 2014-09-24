import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import mypackage.MyTypeSystem;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.CAS;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

import com.aliasi.chunk.Chunk;
import com.aliasi.chunk.Chunker;
import com.aliasi.chunk.Chunking;
import com.aliasi.util.AbstractExternalizable;

public class MyAnnotator extends JCasAnnotator_ImplBase {

  public static final String PARAM_DICTDIR = "DictDirectory";
  
 Chunker mchunker = null;
 
 String mDictPath;
 
 /**
  * Process the CAS provided by the Reader. Analysis tool will load dictionary from project/src/main/resources/MyDict.dic.
  * Sentences will be analyze by tool  and process into phrase and single word. Related information will be put into TypeSystem
  * and be pushed back into CAS.
  */
  @Override
  public void process(JCas aJCas) throws AnalysisEngineProcessException {
    // TODO Auto-generated method stub
    String doc = aJCas.getDocumentText();
    String mark = "";
    FSIterator it = aJCas.getAnnotationIndex(MyTypeSystem.type).iterator();
    MyTypeSystem mts = null;
    if (it.hasNext()) {
      mts = (MyTypeSystem) it.next();
      mark = mts.getMark();
    }
    File modelFile = new File("./src/main/resources", "MyDict.dic");

    Chunker chunker;
    try {
      chunker = (Chunker) AbstractExternalizable.readObject(modelFile);
      Chunking chunking = chunker.chunk(doc);
     // System.out.println("Chunking=" + chunking);
      Set<Chunk> set = chunking.chunkSet();
      Iterator ite = set.iterator();

      while (ite.hasNext()) {
        Chunk c = (Chunk) ite.next();
        MyTypeSystem mys = new MyTypeSystem(aJCas);
        mys.setStart(c.start());
        mys.setEnd(c.end());
        mys.setMark(mark);
        mys.setGene(doc.substring(c.start(), c.end()));
    //    System.out.println(mys.getMark() + " " + mys.getStart() + " " + mys.getEnd() + " "
       //         + mys.getGene());
        mys.addToIndexes(aJCas);
      }

    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    mts.removeFromIndexes(aJCas);
    /*
     * PosTagNamedEntityRecognizer rec; try { rec = new PosTagNamedEntityRecognizer();
     * HashMap<Integer,Integer> map = (HashMap<Integer, Integer>) rec.getGeneSpans(doc);
     * Set<Integer> set = map.keySet(); Iterator<Integer> ite = set.iterator();
     * while(ite.hasNext()){ // CAS acas = aJCas.getCas(); MyTypeSystem mys = new
     * MyTypeSystem(aJCas); int start = ite.next(); mys.setStart(start); int end = map.get(start);
     * mys.setEnd(end); mys.setMark(mark); mys.setGene(doc.substring(start, end));
     * System.out.println(mys.getMark()+" "+mys.getStart()+" "+mys.getEnd()+" "+mys.getGene());
     * mys.addToIndexes(); } } catch (ResourceInitializationException e) { // TODO Auto-generated
     * catch block e.printStackTrace(); }
     */

  }

}
