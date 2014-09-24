

/* First created by JCasGen Sun Sep 21 17:38:16 EDT 2014 */
package mypackage;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Sun Sep 21 17:38:16 EDT 2014
 * XML source: /home/krypton/workspace/hw1-xuweiz/src/main/XML/MyTypeSystem.xml
 * @generated */
public class MyTypeSystem extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(MyTypeSystem.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated  */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected MyTypeSystem() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public MyTypeSystem(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public MyTypeSystem(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public MyTypeSystem(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: gene

  /** getter for gene - gets gene name string
   * @generated */
  public String getGene() {
    if (MyTypeSystem_Type.featOkTst && ((MyTypeSystem_Type)jcasType).casFeat_gene == null)
      jcasType.jcas.throwFeatMissing("gene", "mypackage.MyTypeSystem");
    return jcasType.ll_cas.ll_getStringValue(addr, ((MyTypeSystem_Type)jcasType).casFeatCode_gene);}
    
  /** setter for gene - sets gene name string 
   * @generated */
  public void setGene(String v) {
    if (MyTypeSystem_Type.featOkTst && ((MyTypeSystem_Type)jcasType).casFeat_gene == null)
      jcasType.jcas.throwFeatMissing("gene", "mypackage.MyTypeSystem");
    jcasType.ll_cas.ll_setStringValue(addr, ((MyTypeSystem_Type)jcasType).casFeatCode_gene, v);}    
   
    
  //*--------------*
  //* Feature: start

  /** getter for start - gets 
   * @generated */
  public int getStart() {
    if (MyTypeSystem_Type.featOkTst && ((MyTypeSystem_Type)jcasType).casFeat_start == null)
      jcasType.jcas.throwFeatMissing("start", "mypackage.MyTypeSystem");
    return jcasType.ll_cas.ll_getIntValue(addr, ((MyTypeSystem_Type)jcasType).casFeatCode_start);}
    
  /** setter for start - sets  
   * @generated */
  public void setStart(int v) {
    if (MyTypeSystem_Type.featOkTst && ((MyTypeSystem_Type)jcasType).casFeat_start == null)
      jcasType.jcas.throwFeatMissing("start", "mypackage.MyTypeSystem");
    jcasType.ll_cas.ll_setIntValue(addr, ((MyTypeSystem_Type)jcasType).casFeatCode_start, v);}    
   
    
  //*--------------*
  //* Feature: end

  /** getter for end - gets 
   * @generated */
  public int getEnd() {
    if (MyTypeSystem_Type.featOkTst && ((MyTypeSystem_Type)jcasType).casFeat_end == null)
      jcasType.jcas.throwFeatMissing("end", "mypackage.MyTypeSystem");
    return jcasType.ll_cas.ll_getIntValue(addr, ((MyTypeSystem_Type)jcasType).casFeatCode_end);}
    
  /** setter for end - sets  
   * @generated */
  public void setEnd(int v) {
    if (MyTypeSystem_Type.featOkTst && ((MyTypeSystem_Type)jcasType).casFeat_end == null)
      jcasType.jcas.throwFeatMissing("end", "mypackage.MyTypeSystem");
    jcasType.ll_cas.ll_setIntValue(addr, ((MyTypeSystem_Type)jcasType).casFeatCode_end, v);}    
   
    
  //*--------------*
  //* Feature: mark

  /** getter for mark - gets 
   * @generated */
  public String getMark() {
    if (MyTypeSystem_Type.featOkTst && ((MyTypeSystem_Type)jcasType).casFeat_mark == null)
      jcasType.jcas.throwFeatMissing("mark", "mypackage.MyTypeSystem");
    return jcasType.ll_cas.ll_getStringValue(addr, ((MyTypeSystem_Type)jcasType).casFeatCode_mark);}
    
  /** setter for mark - sets  
   * @generated */
  public void setMark(String v) {
    if (MyTypeSystem_Type.featOkTst && ((MyTypeSystem_Type)jcasType).casFeat_mark == null)
      jcasType.jcas.throwFeatMissing("mark", "mypackage.MyTypeSystem");
    jcasType.ll_cas.ll_setStringValue(addr, ((MyTypeSystem_Type)jcasType).casFeatCode_mark, v);}    
  }

    