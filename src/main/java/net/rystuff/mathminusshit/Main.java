package net.rystuff.mathminusshit;

import org.apache.commons.io.FileUtils;

import java.io.*;

public class Main
{
    public static void main(String[] args)
    {
        int total = 0;
        try
        {
            String content = FileUtils.readFileToString(new File(args[0]));
            try (BufferedReader br = new BufferedReader(new StringReader(stripNonDigits(content)))) {
                String line;
                while ((line = br.readLine()) != null)
                {
                    if (!line.equals(""))
                        total = total+Integer.parseInt(line);
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        System.out.println(total);
    }

    public static String stripNonDigits(CharSequence input) {
        StringBuilder sb = new StringBuilder(input.length());
        for(int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            char p = 0;
            if (i != 0)
                p = input.charAt(i - 1);
            if (c > 47 && c < 58 && p > 47 && p < 58)
                sb.append(c);
            else if (c > 47 && c < 58)
            {
                if (i != 0)
                    sb.append(System.getProperty("line.separator"));
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
