
public class Main {

    /*
    public static void main(String args[])
    {
        int value[] ={8,6,7,10,5};
        int weight[] = {2,3,7,2,3};
        int n = value.length;
        int capacity = 9;
        Frac_knap mainFrackKnap = new Frac_knap(value,weight,capacity,n);

        mainFrackKnap.dirty_sort();
        mainFrackKnap.findSelection();
        System.out.println(mainFrackKnap.getCurrentVal());

        mainFrackKnap.printSelection();
    }
    */

    /*
    public static void main(String args[])
    {
        int value[] ={8,6,7,10,5};
        int weight[] = {2,3,7,2,3};
        int n = value.length;
        int capacity = 9;

        Knap01_R knap_r = new Knap01_R(value,weight,capacity,n);
        knap_r.solveKnap();
        knap_r.displayTable();
        System.out.println(knap_r.result());
    }
    */

    public static void main(String args[])
    {
        int value[] ={8,6,7,10,5};
        int weight[] = {2,3,7,2,3};
        int n = value.length;
        int capacity = 9;
        int resources[] = {1,2,3,1,1};

        Knap01_Nr knap_nr = new Knap01_Nr(value,weight,resources,capacity,n);

        knap_nr.solveKnap();

        System.out.println(knap_nr.result());
    }
}
