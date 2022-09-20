import java.util.Scanner;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
public class Main {

    public static void main(String[] args) throws ScriptException {
        Scanner op = new Scanner(System.in);
        String t0 = op.nextLine();

        Extra d= new Extra();
        d.setData(t0);
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        System.out.println(engine.eval(d.getData()));
    }
}
