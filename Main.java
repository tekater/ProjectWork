import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.*;
public class Main {
    public static String readFileAsString(String filename) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filename)));
    }
    public static int countSyllables(String s) {
        int counter = 0;
        s = s.toLowerCase();
        if(s.contains("the ")){
            counter++;
        }
        String[] split = s.split("e!$|e[?]$|e,|e |e[),]|e$");
        ArrayList<String> al = new ArrayList<String>();
        Pattern tokSplitter = Pattern.compile("[aeiouy]+");
        for (int i = 0; i < split.length; i++) {
            String s1 = split[i];
            Matcher m = tokSplitter.matcher(s1);
            while (m.find()) {
                al.add(m.group());
            }
        }
        counter += al.size();
        return counter;
    }
    public static void main(String[] args) throws IOException {
        String string = new String(Files.readAllBytes(Paths.get("C:\\Users\\file.txt")));
        // берем путь из аргументов командной строки
        String pathToFile = args[0];
        String string = new String(Files.readAllBytes(Paths.get(pathToFile)));

        String[] words = string.split("[\\s]");
        String characters = String.join("", words);
        String[] sentence = string.split("\\.");
        String[] polysyllables = string.split("[aeiouy]{2,}[&&e]$");
        //String[] eee = string.split("$[aeiouy&&[^e]]*");
        System.out.println("Words: " + words.length);
        System.out.println("Sentence: " + sentence.length);
        System.out.println("Characters: " + characters.length());
        System.out.println("Syllables: " + countSyllables(string));
        // сразу считает polysyllables регуляркой
        System.out.println("Polysyllables: " + string.split("([aeiouy]+[^$e(,.:;!?)]){3,}").length);
        //System.out.println("Polysyllables: " + polysyllables.length);
        //System.out.println("eee"+ eee.length);

        int syl = countSyllables(string);
        int ch = characters.length();
        int wo = words.length;
        int sent = sentence.length;
        int polysyl = 17;
        // здесь тоже добавляем polysyllables
        int polysyl = string.split("([aeiouy]+[^$e(,.:;!?)]){3,}").length;
        int L = ch/wo * 100;
        int S = sent/wo * 100;
        System.out.println("Polysyllables: " + polysyl);
        double score = 4.71 * ch / wo + 0.5 * wo / sent - 21.43;
        double score2 = (0.39 * (wo / sent) + 11.8 * (syl / wo) - 15.59);
        double score3 = 1.043 * Math.sqrt(polysyl * (30 / sent)) + 3.1291;
        double score4 = 0.0588 * L - 0.296 * S - 15.8;
        System.out.println("\nThe ARI score is: " + Math.ceil(score));
        //System.out.println("The FK score is: " + score2);
        System.out.println("The FK score is: " + Math.ceil(score2));
        System.out.println("The SMOG score is: " + Math.ceil(score3));
        System.out.println("The Coleman–Liau score is: " + Math.ceil(score4));
        System.out.println("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): ");
        String input = new java.util.Scanner(System.in).nextLine();
        switch (input){
        case"ari": //if(input == "ari") {
            System.out.println("ARI: ");
            double action = Math.ceil(score);
            // javac .\Main.java
            // java Main
            switch ((int)action) {    // Math.ceil(a) | Math.floor(a)
                case 5:
                    System.out.println("This text should be understood by 5-6 year-olds." + " " + "For Kindergarten");
                    break;
                case 6:
                    System.out.println("This text should be understood by 6-7 year-olds." + " " + "For First/Secind Grade");
                    break;
                case 7:
                    System.out.println("This text should be understood by 7-9 year-olds." + " " + "For Third Grade");
                    break;
                case 8:
                    System.out.println("This text should be understood by 7-9 year-olds." + " " + "For Third Grade");
                    break;
                case 9:
                    System.out.println("This text should be understood by 9-10 year-olds." + " " + "For Fourth Grade");
                    break;
                case 10:
                    System.out.println("This text should be understood by 10-11 year-olds." + " " + "For Fifth Grade");
                    break;
                case 11:
                    System.out.println("This text should be understood by 11-12 year-olds." + " " + "For Sixth Grade");
                    break;
                case 12:
                    System.out.println("This text should be understood by 12-13 year-olds." + " " + "For Seventh Grade");
                    break;
                case 13:
                    System.out.println("This text should be understood by 13-14 year-olds." + " " + "For Eighth Grade");
                    break;
                case 14:
                    System.out.println("This text should be understood by 14-15 year-olds." + " " + "For Ninth Grade");
                    break;
                case 15:
                    System.out.println("This text should be understood by 15-16 year-olds." + " " + "For Tenth Grade");
                    break;
                case 16:
                    System.out.println("This text should be understood by 16-17 year-olds." + " " + "For Eleventh Grade");
                    break;
                case 17:
                    System.out.println("This text should be understood by 17-18 year-olds." + " " + "For Twelfth Grade");
                    break;
                case 18:
                    System.out.println("This text should be understood by 18-24 year-olds." + " " + "For College Student");
                    break;
                case 19:
                    System.out.println("This text should be understood by 18-24 year-olds." + " " +  "For College Student");
                    break;
                case 20:
                    System.out.println("This text should be understood by 18-24 year-olds." +  " " + "For College Student");
                    break;
                case 21:
                    System.out.println("This text should be understood by 18-24 year-olds." + " " +  "For College Student");
                    break;
                case 22:
                    System.out.println("This text should be understood by 18-24 year-olds." + " " +  "For College Student");
                    break;
                case 23:
                    System.out.println("This text should be understood by 18-24 year-olds." + " " +  "For College Student");
                    break;
                case 24:
                    System.out.println("This text should be understood by 24+ year-olds." + " " +  "For Professor");
                    break;
                default:
                    System.out.println("Not statement");
            }
        } switch (input){ //else if(input == "fk") {
            case "fk":
                System.out.println("FK: ");
            if (score2 > 0 & score2 < 10 ) {
                System.out.println("Professional");
            }else if (score2 >= 10 & score2 <= 30) {
                System.out.println("College graduate");
            }else if (score2 >= 30 & score2 <= 50) {
                System.out.println("College");
            }else if (score2 >= 50 & score2 <= 60) {
                System.out.println("10th to 12th grade");
            }else if (score2 >= 60 & score2 <= 70) {
                System.out.println("8th & 9th grade");
            }else if (score2 >= 70 & score2 <= 80) {
                System.out.println("7th grade");
            }else if (score2 >= 80 & score2 <= 90) {
                System.out.println("6th grade");
            }else if (score2 >= 90 & score2 <= 100) {
                System.out.println("5th grade");
            }else{
                System.out.println("Not statement");
            }
            break;
            case"smog": //else if(input == "smog") {
            System.out.println("SMOG: ");
            if (score3 > 1 & score3< 6){
                System.out.println("5 years old");
            }else if(score3 >= 7 & score3<= 12) {
                System.out.println("6 years old");
            }else if(score3 >= 13 & score3<= 20) {
                System.out.println("7 years old");
            }else if(score3 >= 21 & score3<= 30) {
                System.out.println("8 years old");
            }else if(score3 >= 31 & score3<= 42) {
                System.out.println("9 years old");
            }else if(score3 >= 43 & score3<= 56) {
                System.out.println("10 years old");
            }else if(score3 >= 57 & score3<= 72) {
                System.out.println("11 years old");
            }else if(score3 >= 73 & score3<= 90) {
                System.out.println("12 years old");
            }else if(score3 >= 91 & score3<= 110) {
                System.out.println("13 years old");
            }else if(score3 >= 111 & score3<= 132) {
                System.out.println("14 years old");
            }else if(score3 >= 133 & score3<= 156) {
                System.out.println("15 years old");
            }else if(score3 >= 157 & score3<= 182) {
                System.out.println("16 years old");
            }else if(score3 >= 183 & score3<= 210) {
                System.out.println("17 years old");
            }else if(score3 >= 211 & score3<= 240) {
                System.out.println("18 years old");
            }else{
                System.out.println("Not statement");
            }
            case"cl": //else if(input == "cl") {
            System.out.println("CL: ");
            if (score4 >= 0 & score4 <= 6){
                System.out.println("6th Grade");
            }else if (score4 <= 7) {
                System.out.println("7th Grade");
            }else if (score4 <= 8) {
                System.out.println("8th Grade");
            }else if (score4 <= 9) {
                System.out.println("High school freshman");
            }else if (score4 <= 10) {
                System.out.println("High school sophomore");
            }else if (score4 <= 11) {
                System.out.println("High school junior");
            }else if (score4 <= 12) {
                System.out.println("High school senior");
            }else if (score4 <= 13) {
                System.out.println("College freshman");
            }else if (score4 <= 14) {
                System.out.println("College sophomore");
            }else{
                System.out.println("Not statement");
            }
            case"all": //else if (input == "all") {
            //ARI
            System.out.println("ARI: ");
            double action = Math.ceil(score);
            switch ((int)action) {    // Math.ceil(a) | Math.floor(a)
                case 5:
                    System.out.println("This text should be understood by 5-6 year-olds." + " " + "For Kindergarten");
                    break;
                case 6:
                    System.out.println("This text should be understood by 6-7 year-olds." + " " + "For First/Secind Grade");
                    break;
                case 7:
                    System.out.println("This text should be understood by 7-9 year-olds." + " " + "For Third Grade");
                    break;
                case 8:
                    System.out.println("This text should be understood by 7-9 year-olds." + " " + "For Third Grade");
                    break;
                case 9:
                    System.out.println("This text should be understood by 9-10 year-olds." + " " + "For Fourth Grade");
                    break;
                case 10:
                    System.out.println("This text should be understood by 10-11 year-olds." + " " + "For Fifth Grade");
                    break;
                case 11:
                    System.out.println("This text should be understood by 11-12 year-olds." + " " + "For Sixth Grade");
                    break;
                case 12:
                    System.out.println("This text should be understood by 12-13 year-olds." + " " + "For Seventh Grade");
                    break;
                case 13:
                    System.out.println("This text should be understood by 13-14 year-olds." + " " + "For Eighth Grade");
                    break;
                case 14:
                    System.out.println("This text should be understood by 14-15 year-olds." + " " + "For Ninth Grade");
                    break;
                case 15:
                    System.out.println("This text should be understood by 15-16 year-olds." + " " + "For Tenth Grade");
                    break;
                case 16:
                    System.out.println("This text should be understood by 16-17 year-olds." + " " + "For Eleventh Grade");
                    break;
                case 17:
                    System.out.println("This text should be understood by 17-18 year-olds." + " " + "For Twelfth Grade");
                    break;
                case 18:
                    System.out.println("This text should be understood by 18-24 year-olds." + " " + "For College Student");
                    break;
                case 19:
                    System.out.println("This text should be understood by 18-24 year-olds." + " " +  "For College Student");
                    break;
                case 20:
                    System.out.println("This text should be understood by 18-24 year-olds." +  " " + "For College Student");
                    break;
                case 21:
                    System.out.println("This text should be understood by 18-24 year-olds." + " " +  "For College Student");
                    break;
                case 22:
                    System.out.println("This text should be understood by 18-24 year-olds." + " " +  "For College Student");
                    break;
                case 23:
                    System.out.println("This text should be understood by 18-24 year-olds." + " " +  "For College Student");
                    break;
                case 24:
                    System.out.println("This text should be understood by 24+ year-olds." + " " +  "For Professor");
                    break;
                default:
                    System.out.println("Not statement");
            }
            //FK
            System.out.println("FK: ");
            if (score2 > 0 & score2 < 10 ) {
                System.out.println("Professional");
            }else if (score2 >= 10 & score2 <= 30) {
                System.out.println("College graduate");
            }else if (score2 >= 30 & score2 <= 50) {
                System.out.println("College");
            }else if (score2 >= 50 & score2 <= 60) {
                System.out.println("10th to 12th grade");
            }else if (score2 >= 60 & score2 <= 70) {
                System.out.println("8th & 9th grade");
            }else if (score2 >= 70 & score2 <= 80) {
                System.out.println("7th grade");
            }else if (score2 >= 80 & score2 <= 90) {
                System.out.println("6th grade");
            }else if (score2 >= 90 & score2 <= 100) {
                System.out.println("5th grade");
            }else{
                System.out.println("Not statement");
            }
            //SMOG
            System.out.println("SMOG: ");
            if (score3 > 1 & score3< 6){
                System.out.println("5 years old");
            }else if(score3 >= 7 & score3<= 12) {
                System.out.println("6 years old");
            }else if(score3 >= 13 & score3<= 20) {
                System.out.println("7 years old");
            }else if(score3 >= 21 & score3<= 30) {
                System.out.println("8 years old");
            }else if(score3 >= 31 & score3<= 42) {
                System.out.println("9 years old");
            }else if(score3 >= 43 & score3<= 56) {
                System.out.println("10 years old");
            }else if(score3 >= 57 & score3<= 72) {
                System.out.println("11 years old");
            }else if(score3 >= 73 & score3<= 90) {
                System.out.println("12 years old");
            }else if(score3 >= 91 & score3<= 110) {
                System.out.println("13 years old");
            }else if(score3 >= 111 & score3<= 132) {
                System.out.println("14 years old");
            }else if(score3 >= 133 & score3<= 156) {
                System.out.println("15 years old");
            }else if(score3 >= 157 & score3<= 182) {
                System.out.println("16 years old");
            }else if(score3 >= 183 & score3<= 210) {
                System.out.println("17 years old");
            }else if(score3 >= 211 & score3<= 240) {
                System.out.println("18 years old");
            }else{
                System.out.println("Not statement");
            }
            //CL
            System.out.println("CL: ");
            if (score4 >= 0 & score4 <= 6){
                System.out.println("6th Grade");
            }else if (score4 <= 7) {
                System.out.println("7th Grade");
            }else if (score4 <= 8) {
                System.out.println("8th Grade");
            }else if (score4 <= 9) {
                System.out.println("High school freshman");
            }else if (score4 <= 10) {
                System.out.println("High school sophomore");
            }else if (score4 <= 11) {
                System.out.println("High school junior");
            }else if (score4 <= 12) {
                System.out.println("High school senior");
            }else if (score4 <= 13) {
                System.out.println("College freshman");
            }else if (score4 <= 14) {
                System.out.println("College sophomore");
            }else{
                System.out.println("Not statement");
            }
        }
    }
}
