package com.example.day2;

public class RegularExpression {
    public static void main(String[] args) {

        String ssn = "123-45-6789"; // XXX-YY-ZZZZ

        // way-1 : using string methods
        boolean isValid=true;
        if(ssn.length()==11){
            if(ssn.charAt(3)=='-' && ssn.charAt(6)=='-'){
                for(int i=0;i<ssn.length();i++){
                    if(i!=3 && i!=6){
                        if(!Character.isDigit(ssn.charAt(i))){
                            isValid=false;
                            break;
                        }
                    }
                }
            }else{
                isValid=false;
            }

        }else{
            isValid=false;
        }

        if(isValid){
            System.out.println("Valid SSN");
        }else{
            System.out.println("Invalid SSN");
        }


        // Regular expressions are used for:
        // - validation
        // - search
        // - replace

        // way-2 : using regex
        String regex = "\\d{3}-\\d{2}-\\d{4}"; // XXX-YY-ZZZZ
        if(ssn.matches(regex)){
            System.out.println("Valid SSN");
        }else{
            System.out.println("Invalid SSN");
        }


        // way-3 : using regex with Pattern and Matcher classes
        String regex2 = "\\d{3}-\\d{2}-\\d{4}"; // XXX-YY-ZZZZ
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regex2);
        java.util.regex.Matcher matcher = pattern.matcher(ssn);

        if(matcher.matches()){
            System.out.println("Valid SSN");
        }else {
            System.out.println("Invalid SSN");
        }

        // way-3 : replace bad words with '*'
        String text = "This is a bad word. This is another bad word.";
        String badWordRegex = "\\bbad\\b"; // \b is used to match word boundaries
        String replacement = "****";

        // Using Pattern and Matcher

        java.util.regex.Pattern badWordPattern = java.util.regex.Pattern.compile(badWordRegex);
        java.util.regex.Matcher badWordMatcher = badWordPattern.matcher(text);
        String result = badWordMatcher.replaceAll(replacement);
        System.out.println(result); // This is a **** word. This is another **** word.

    }
}
