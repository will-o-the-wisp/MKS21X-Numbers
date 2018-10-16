public class RationalNumber extends RealNumber{
  private int num;
  private int denom;
  public RationalNumber(double x){
    super(x);
  }
  public RationalNumber(int top, int bot){
    super(top/bot);
  }
  public int getNum(){
    return 1;
  }
  public int getDenom(){
    return -1;
  }
  public String toString(){
    return "a";
  }
  public int compareToRational(RationalNumber z){
    return 0;
  }
  public void reduce(){
  }
}
