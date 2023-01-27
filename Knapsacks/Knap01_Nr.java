/**
 * Created by kernel on 27-07-2020.
 */
public class Knap01_Nr {
    public int value[], weight[];
    public int cap,size;
    public int cutPasteTable[][];
    public int utilityTable[][][];
    public int maxResources[];

    Knap01_Nr(int value[], int weight[], int maxResources[],int cap, int size)
    {
        this.value = value;
        this.weight = weight;
        this.maxResources = maxResources;
        this.cap = cap;
        this.size = size;
        this.cutPasteTable = new int[cap+1][size+1];
        this.utilityTable = new int[cap+1][size+1][size];
    }

    int max(int a, int b)
    {
        return a>b ? a :  b;
    }

    boolean check_valid(int utilCollection[],int location)
    {
        return utilCollection[location] <= maxResources[location];
    }

    void copyUtil(int utilCollection[],int copyFrom[],int n)
    {
        for(int i=0;i<n;i++)
        {
            utilCollection[i] = copyFrom[i];
        }
    }
    void solveKnap()
    {
        for(int i=1;i<cap+1;i++)
        {
            for(int j=1;j<size+1;j++)
            {
                if(weight[j-1]>i)
                {
                    cutPasteTable[i][j] = max(cutPasteTable[i][j-1],cutPasteTable[i-1][j]);
                    if(cutPasteTable[i][j] == cutPasteTable[i][j-1])
                    {
                        copyUtil(utilityTable[i][j],utilityTable[i][j-1],size);
                    }
                    else
                    {
                        copyUtil(utilityTable[i][j],utilityTable[i-1][j],size);
                    }
                }
                else
                {
                    int tempArr[] = new int[size];

                    copyUtil(tempArr,utilityTable[i - weight[j-1]][j],size);
                    tempArr[j-1]+=1;

                    if(check_valid(tempArr,j-1))
                    {
                        cutPasteTable[i][j]= max(value[j-1]+ cutPasteTable[i- weight[j-1]][j],max(cutPasteTable[i][j-1],cutPasteTable[i-1][j]));
                        if(cutPasteTable[i][j] == cutPasteTable[i-1][j])
                        {
                            copyUtil(utilityTable[i][j],utilityTable[i-1][j],size);
                        }
                        else if(cutPasteTable[i][j] == cutPasteTable[i][j-1])
                        {
                            copyUtil(utilityTable[i][j],utilityTable[i][j-1],size);
                        }
                        else
                        {
                            copyUtil(utilityTable[i][j],tempArr,size);
                        }

                    }
                    else
                    {
                        cutPasteTable[i][j] = max(cutPasteTable[i][j-1],cutPasteTable[i-1][j]);
                        if(cutPasteTable[i][j] == cutPasteTable[i][j-1])
                        {
                            copyUtil(utilityTable[i][j],utilityTable[i][j-1],size);
                        }
                        else
                        {
                            copyUtil(utilityTable[i][j],utilityTable[i-1][j],size);
                        }
                    }
                }
            }
        }
    }

    int result()
    {
        return cutPasteTable[cap][size];
    }
}
