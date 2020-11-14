/**
 * Created by kernel on 27-07-2020.
 */

public class Knap01_R {

    public int value[], weight[];
    public int cap,size;
    public int cutPasteTable[][];

    Knap01_R(int value[], int weight[], int cap, int size)
    {
        this.value = value;
        this.weight = weight;
        this.cap = cap;
        this.size = size;

        cutPasteTable = new int[cap+1][size+1];
    }

    int max(int a,int b)
    {
        return a>b? a : b;
    }
    void solveKnap()
    {
        for (int i=1;i<cap+1;i++)
        {
            for(int j=1;j<size+1;j++)
            {
                if(weight[j-1]>i)
                {
                    cutPasteTable[i][j] = max(cutPasteTable[i-1][j],cutPasteTable[i][j-1]);
                }
                else
                {
                    cutPasteTable[i][j] = max(max(cutPasteTable[i-1][j],cutPasteTable[i][j-1]), value[j-1] + cutPasteTable[i - weight[j-1]][j]);
                }
            }
        }

    }

    int result()
    {
        return cutPasteTable[cap][size];
    }

    void displayTable()
    {
        for(int i=0;i<cap+1;i++)
        {
            for(int j= 0;j<size+1;j++)
            {
                System.out.print(" " + cutPasteTable[i][j]);
            }
            System.out.println("");
        }
    }
}
