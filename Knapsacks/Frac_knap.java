/**
 * Created by kernel on 27-07-2020.
 */

public class Frac_knap {

    int value[];int weight[]; int cap; int size; float currentCap, currentVal;
    float ratioValue[];
    float selection[];
    int refArr[];

    Frac_knap(int[] value,int[] weight,int capacity,int size)
    {
         this.value = value;
         this.weight = weight;
         this.cap = capacity;
         this.size = size;
         this.currentCap = 0.0f;
         this.currentVal = 0.0f;
         ratioValue = new float[size];
         selection = new float[size];
         refArr = new int[size];

         for(int i=0;i<size;i++)
         {
             ratioValue[i] =(float)value[i]/weight[i];
             refArr[i]=i;
         }

    }

    void dirty_sort()
    {
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size-1;j++)
            {
                if(ratioValue[refArr[j]]<ratioValue[refArr[j+1]])
                {
                    int temp = refArr[j];
                    refArr[j] = refArr[j+1];
                    refArr[j+1] = temp;
                }
            }
        }
    }

    void findSelection()
    {
        int startIndex = 0;
        while(currentCap<cap)
        {
            if(weight[refArr[startIndex]] +currentCap<=cap)
            {
                currentCap+= weight[refArr[startIndex]];
                currentVal+= value[refArr[startIndex]];
                selection[refArr[startIndex]] = 1;
                System.out.println("Added "+refArr[startIndex]);
            }
            else
            {
                float ratio = (cap - currentCap)/weight[refArr[startIndex]];
                currentCap+= (cap - currentCap);
                currentVal+= value[refArr[startIndex]]* ratio;
                selection[refArr[startIndex]] = ratio;
                System.out.println("Added "+refArr[startIndex]);
            }
            startIndex++;
        }
    }

    float getCurrentCap()
    {
        return currentCap;
    }

    float getCurrentVal()
    {
        return currentVal;
    }

    void printSelection()
    {
        for(int iter = 0; iter<size;iter++)
        {
            System.out.print(String.format("%f ",selection[iter]));
        }
    }

}
