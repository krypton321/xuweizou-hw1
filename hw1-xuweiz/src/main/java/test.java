import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import mypackage.MyTypeSystem;

import org.apache.uima.cas.FSIterator;

import com.aliasi.chunk.Chunk;
import com.aliasi.chunk.Chunker;
import com.aliasi.chunk.Chunking;
import com.aliasi.chunk.ConfidenceChunker;
import com.aliasi.chunk.NBestChunker;
import com.aliasi.util.AbstractExternalizable;
import com.aliasi.util.Strings;

public class test {
  public static void main(String[] args) throws IOException, ClassNotFoundException {
 //   File modelFile = new File("src/main/resorces","ne-en-bio-genetag.HmmChunker");
/*    File modelFile = new File("./src/main/resources","ne-en-bio-genetag.HmmChunker");

    System.out.println("Reading chunker from file=" + modelFile);
    Chunker chunker
        = (Chunker) AbstractExternalizable.readObject(modelFile);

   
        Chunking chunking = chunker.chunk("Teratological study of etoperidone in the rat and rabbit.");
        System.out.println("Chunking=" + chunking);
        Set<Chunk> c=chunking.chunkSet();
       Iterator it = c.iterator();
       String s =" ab c d ";
       System.out.println(s);
       System.out.println(s.trim());
       while(it.hasNext()){
        Chunk ch = (Chunk) it.next();
        
        
        System.out.println(ch.start());
       }
    //    Chunk[] ch=(Chunk[]) c.toArray();
*/
    File modelFile = new File("./src/main/resources","ne-en-bio-genetag.HmmChunker");
    ConfidenceChunker chunker
    = (ConfidenceChunker) AbstractExternalizable.readObject(modelFile);
  //  String s ="59 cases of surgically resectable cancers (T1, T2, T3, N0, N1) had a minimum followup of two years (average 4 years +/- 3 months).";
 //   String s ="The variable HMG dosage regimen was found to offer no advantages when compared with our standard daily dosage regimen.";
    String s = "By contrast, secretory HI antibodies were not demonstrated at the onset of illness in any of the patients, but their formation started early and the antibodies reached maximal levels about 10 days after onset of illness.";
    System.out.println(s.substring(0, 5));
    System.out.println(s.substring(1, 3));
    char[] cs = s.toCharArray();
    Iterator<Chunk> it
      = chunker.nBestChunks(cs,0,cs.length,5);
   // System.out.println(args[i]);
    System.out.println("Rank          Conf      Span    Type     Phrase");
    for (int n = 0; it.hasNext(); ++n) {
        Chunk chunk = it.next();
        double conf = Math.pow(2.0,chunk.score());
        int start = chunk.start();
        int end = chunk.end();
        String phrase = s.substring(start,end);
        System.out.println(n + " "
                           + "         "+conf
                           + "       (" + start
                           + ", " + end
                           + ")       " + chunk.type()
                           + "         " + phrase);
     }

    
 
  }
}
