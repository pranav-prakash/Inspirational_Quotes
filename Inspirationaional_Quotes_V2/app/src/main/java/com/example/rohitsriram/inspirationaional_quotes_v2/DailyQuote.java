package com.example.rohitsriram.inspirationaional_quotes_v2;

import android.content.Context;
import android.content.res.Resources;
import java.util.Random;

/**
 * Created by pranav on 7/16/15.
 */
public class DailyQuote {

    private static String dailyQuote;
    private static String[] Quotes;

    public static String getDailyQuote()
    {
        return dailyQuote;
    }

    public DailyQuote(String[] Quotes)
    {
        this.Quotes = Quotes;
        if (dailyQuote == null) generateNewQuote();
    }

    public static String generateNewQuote(){
        Random random = new Random();
        String quote = Quotes[random.nextInt(Quotes.length)]; //return a random quote from Quotes array
        dailyQuote = quote;
        return quote;
    }

}
