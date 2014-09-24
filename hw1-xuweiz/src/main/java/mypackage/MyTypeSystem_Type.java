
/* First created by JCasGen Sun Sep 21 17:38:16 EDT 2014 */
package mypackage;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.Annotation_Type;

/** 
 * Updated by JCasGen Sun Sep 21 17:38:16 EDT 2014
 * @generated */
public class MyTypeSystem_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (MyTypeSystem_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = MyTypeSystem_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new MyTypeSystem(addr, MyTypeSystem_Type.this);
  			   MyTypeSystem_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new MyTypeSystem(addr, MyTypeSystem_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = MyTypeSystem.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("mypackage.MyTypeSystem");
 
  /** @generated */
  final Feature casFeat_gene;
  /** @generated */
  final int     casFeatCode_gene;
  /** @generated */ 
  public String getGene(int addr) {
        if (featOkTst && casFeat_gene == null)
      jcas.throwFeatMissing("gene", "mypackage.MyTypeSystem");
    return ll_cas.ll_getStringValue(addr, casFeatCode_gene);
  }
  /** @generated */    
  public void setGene(int addr, String v) {
        if (featOkTst && casFeat_gene == null)
      jcas.throwFeatMissing("gene", "mypackage.MyTypeSystem");
    ll_cas.ll_setStringValue(addr, casFeatCode_gene, v);}
    
  
 
  /** @generated */
  final Feature casFeat_start;
  /** @generated */
  final int     casFeatCode_start;
  /** @generated */ 
  public int getStart(int addr) {
        if (featOkTst && casFeat_start == null)
      jcas.throwFeatMissing("start", "mypackage.MyTypeSystem");
    return ll_cas.ll_getIntValue(addr, casFeatCode_start);
  }
  /** @generated */    
  public void setStart(int addr, int v) {
        if (featOkTst && casFeat_start == null)
      jcas.throwFeatMissing("start", "mypackage.MyTypeSystem");
    ll_cas.ll_setIntValue(addr, casFeatCode_start, v);}
    
  
 
  /** @generated */
  final Feature casFeat_end;
  /** @generated */
  final int     casFeatCode_end;
  /** @generated */ 
  public int getEnd(int addr) {
        if (featOkTst && casFeat_end == null)
      jcas.throwFeatMissing("end", "mypackage.MyTypeSystem");
    return ll_cas.ll_getIntValue(addr, casFeatCode_end);
  }
  /** @generated */    
  public void setEnd(int addr, int v) {
        if (featOkTst && casFeat_end == null)
      jcas.throwFeatMissing("end", "mypackage.MyTypeSystem");
    ll_cas.ll_setIntValue(addr, casFeatCode_end, v);}
    
  
 
  /** @generated */
  final Feature casFeat_mark;
  /** @generated */
  final int     casFeatCode_mark;
  /** @generated */ 
  public String getMark(int addr) {
        if (featOkTst && casFeat_mark == null)
      jcas.throwFeatMissing("mark", "mypackage.MyTypeSystem");
    return ll_cas.ll_getStringValue(addr, casFeatCode_mark);
  }
  /** @generated */    
  public void setMark(int addr, String v) {
        if (featOkTst && casFeat_mark == null)
      jcas.throwFeatMissing("mark", "mypackage.MyTypeSystem");
    ll_cas.ll_setStringValue(addr, casFeatCode_mark, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public MyTypeSystem_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_gene = jcas.getRequiredFeatureDE(casType, "gene", "uima.cas.String", featOkTst);
    casFeatCode_gene  = (null == casFeat_gene) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_gene).getCode();

 
    casFeat_start = jcas.getRequiredFeatureDE(casType, "start", "uima.cas.Integer", featOkTst);
    casFeatCode_start  = (null == casFeat_start) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_start).getCode();

 
    casFeat_end = jcas.getRequiredFeatureDE(casType, "end", "uima.cas.Integer", featOkTst);
    casFeatCode_end  = (null == casFeat_end) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_end).getCode();

 
    casFeat_mark = jcas.getRequiredFeatureDE(casType, "mark", "uima.cas.String", featOkTst);
    casFeatCode_mark  = (null == casFeat_mark) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_mark).getCode();

  }
}



    