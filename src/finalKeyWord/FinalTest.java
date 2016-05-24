package finalKeyWord;

/**
 * 5/24/16.
 * Never forget your dream
 */
public class FinalTest {
    private final int number; //final doesn't mean that its value is know at compile time.
    private final Value valueObj = new Value(100);

    public FinalTest(int number){
        this.number = number;
    }

    //final reference's value can be modified, but cannot point to new object.
    public void changeFinalReferenceObjectValue(){
        valueObj.i = 1000;
    }

    public void pointToNewObj(){
        //valueObj = new Value(10000);
    }
}
