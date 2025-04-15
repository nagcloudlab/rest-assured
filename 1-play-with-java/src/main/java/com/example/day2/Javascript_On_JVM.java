package com.example.day2;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Javascript_On_JVM {
    public static void main(String[] args) throws ScriptException {

        // Get Nashorn engine
        ScriptEngine engine=new ScriptEngineManager().getEngineByName("nashorn");

        // javascript code
        String script="var a=10; var b=20; var c=a+b; c;";

        // Evaluate the script
        Object result=engine.eval(script);
        System.out.println(result);


    }
}
