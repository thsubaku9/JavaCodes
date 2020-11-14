/**
 * Created by kernel on 27-07-2020.
 */
public class BnB_knap {
    public float value[], weight[];
    public float cap,size;
    public float netWt, netVal;
    public static float currentMaxVal,currentMaxWt;
    BnB_knap(float value[], float weight[], float cap, float size)
    {
        this.value = value;
        this.weight = weight;
        this.cap = cap;
        this.size = size;
        netWt = 0; netVal = 0;
        for(int i=0;i<size;i++)
        {
            netWt+= weight[i];
            netVal+= value[i];
        }
        currentMaxVal = 0; currentMaxWt = 0;
    }

    void commencebnb(int selection, float currentVal, float currentWt,float maxAttainable)
    {
        if(selection >= size)
        {
            if(currentVal > currentMaxVal && currentWt<=cap)
            {
                currentMaxVal = currentVal; currentMaxWt = currentWt;
            }
        }
        else
        {
            commencebnb(selection+1,currentVal,currentWt,maxAttainable - value[selection]);
            if(currentWt+weight[selection] <= cap && (maxAttainable + currentVal > currentMaxVal ))
            {
                commencebnb(selection+1,currentVal+value[selection],currentWt+weight[selection],maxAttainable - value[selection]);
            }
        }
    }

    void startbnb()
    {
        commencebnb(0,0,0,netVal);
        System.out.println(String.format("Value: %d and Weight: %d",currentMaxVal,currentMaxWt));
    }


}
