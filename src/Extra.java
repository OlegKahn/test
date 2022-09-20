import javax.script.ScriptException;

public class Extra implements Extra2 {

    String t1 = "";//like list with numbers
    String t3 = "";

public void setData(String t0) {
    int n1 = 0;//sign last
    String t2 = "";//like list with sign
    int n2 = 0;//number balancer
    int n3 = 0;
    int e = 0;//if it's not sign or number
    int n0 = t0.length();
    if (n0 > 9||t0.length()==0)
    {
        System.out.println("Error, too many or few signs or numbers");
        System.exit(0);
    }
    if (Character.toString(t0.charAt(0)).matches("^[*+/]"))
    {
        System.out.println("Error, first sign can be only -, another can not be");
        System.exit(0);
    }
    else
    {
        for (int i = 0; i < n0; i++) {
            char ch0 = t0.charAt(i);
            if (Character.toString(ch0).matches("[-+]?\\d+"))
            {
                if (Character.getNumericValue(ch0) != 0)
                {
                    n2 = n2 + 1;
                }
                if (Character.getNumericValue(ch0) == 0) {
                    n2 = n2 - 2;
                    n3 = n3 + 1;
                }
                if (i > 0 && Character.getNumericValue(ch0) == 0) {
                    if (Character.getNumericValue(t0.charAt(i - 1)) == 1) {
                        n2 = n2 + 1;
                        n3 = n3 + 1;
                    }
                }
                t1 = t1 + ch0;
                n1 = 0;
                if (i != 0) {
                    t2 = t2 + "@";
                }
            }
            else if (Character.toString(ch0).matches("[-+*/]"))
            {
                if (i != 0 && i != n0 - 1)
                {
                    t1 = t1 + "-";
                }
                if (i > 0)
                {
                    if (Character.getNumericValue(t0.charAt(i - 1)) != 0)
                    {
                        n2 = n2 - 1;
                    }
                }
                t2 = t2 + t0.charAt(i);
                n1 = n1 + 1;
                n3 = 0;
            }
            else
            {
                e = 1;
                break;
            }
            if (e > 0)
            {
                break;
            }
            if (n2 != 0 && n2 != 1 || n3 > 2)
            {
                System.out.println("Error, only numbers 1-10 or interfere extra signs");
                System.exit(0);
            }
        }
        if (e > 0)
        {
            System.out.println("Error, write only integer and signs +-*/");
            System.exit(0);
        }
        else if (n1 != 0)
        {
            System.out.println("Error, last symbol must be number");
            System.exit(0);
        }
    }
    String[] subStr;
    subStr = t1.split("-");
    if(subStr.length>3||subStr.length<2)
    {
        System.out.println("Error, too many or few variables");
        System.exit(0);
    }
    t3=t0;
}
    public String getData()
    {
        return t3;
    }
}
