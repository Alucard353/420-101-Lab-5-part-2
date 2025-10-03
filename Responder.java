import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

/**
 * The responder class represents a response generator object. It is used
 * to generate an automatic response. This is the second version of this 
 * class. This time, we generate some random behavior by randomly selecting 
 * a phrase from a predefined list of responses.
 * 
 * @author   Michael Kölling and David J. Barnes
 * @version 7.2
 */
public class Responder
{
    private Random randomGenerator;
    
    private ArrayList<String> defaultResponses;
    
    private HashMap<String, String> responseMap;
    private Random generator;
    private ArrayList<String> responses;

    /**
     * Construct a Responder
     */
    public Responder()
    {
        responseMap = new HashMap<>();
        defaultResponses = new ArrayList<>();
        fillResponseMap();
        fillDefaultResponses();
        generator = new Random();
        responses = new ArrayList<>();
    }

    /**
     * Generate a response.
     * 
     * @return  A string that should be displayed as the response
     */
    public String generateResponse(HashSet<String> words)
    {
       for (String word : words) {
           String response = responseMap.get(word);
           if(response != null) {
               return response;
           }
       }
       return responses.get(generator,nextInt(responses.size()));
    }

    /**
     * Enter all the known keywords and their associated responses
     * into our response map.
     */
    private void fillResponseMap()
    {
        responseMap.put("crash", 
                        """
                        Well, it never crashes on our system. It must have something
                        to do with your system. Tell me more about your configuration.
                        """);
        responseMap.put("crashes", 
                        """
                        Well, it never crashes on our system. It must have something
                        "to do with your system. Tell me more about your configuration.
                        """);
        responseMap.put("slow", 
                        """
                        I think this has to do with your hardware. Upgrading your processor
                        should solve all performance problems. Have you got a problem with
                        our software?
                        """);
        responseMap.put("performance", 
                        """
                        Performance was quite adequate in all our tests. Are you running
                        any other processes in the background?
                        """);
        responseMap.put("bug", 
                        """
                        Well, you know, all software has some bugs. But our software engineers
                        are working very hard to fix them. Can you describe the problem a bit
                        further?
                        """);
        responseMap.put("buggy", 
                        """
                        Well, you know, all software has some bugs. But our software engineers
                        "are working very hard to fix them. Can you describe the problem a bit
                        further?
                        """);
        responseMap.put("windows", 
                        """
                        This is a known bug to do with the Windows operating system. Please
                        report it to Microsoft. There is nothing we can do about this.
                        """);
        responseMap.put("mac", 
                        """
                        This is a known bug to do with the Mac operating system. Please
                        report it to Apple. There is nothing we can do about this.
                        """);
        responseMap.put("expensive", 
                        """
                        The cost of our product is quite competitive. Have you looked around
                        and really compared our features?
                        """);
        responseMap.put("installation", 
                        """
                        The installation is really quite straight forward. We have tons of
                        "wizards that do all the work for you. Have you read the installation
                        instructions?
                        """);
        responseMap.put("memory", 
                        """
                        If you read the system requirements carefully, you will see that the
                        specified memory requirements are 1.5 giga byte. You really should
                        upgrade your memory. Anything else you want to know?
                        """);
        responseMap.put("linux", 
                        """
                        We take Linux support very seriously. But there are some problems.
                        Most have to do with incompatible glibc versions. Can you be a bit
                        more precise?
                        """);
        responseMap.put("bluej", 
                        """
                        Ahhh, BlueJ, yes. We tried to buy out those guys long ago, but
                        they simply won't sell... Stubborn people they are. Nothing we can
                        do about it, I'm afraid.
                        """);
    }
    
    /**
     * Build up a list of default responses from which we can pick one
     * if we don't know what else to say.
     */
    private void fillDefaultResponses()
    {
        defaultResponses.add("That sounds odd. Could you describe that problem in more detail?");
        defaultResponses.add("""
                             No other customer has ever complained about this before.
                             What is your system configuration?
                             """);
        defaultResponses.add("That sounds interesting. Tell me more...");
        defaultResponses.add("I need a bit more information on that.");
        defaultResponses.add("Have you checked that you do not have a dll conflict?");
        defaultResponses.add("That is explained in the manual. Have you read the manual?");
        defaultResponses.add("""
                             Your description is a bit wishy-washy. Have you got an expert
                             there with you who could describe this more precisely?
                             """);
        defaultResponses.add("That's not a bug, it's a feature!");
        defaultResponses.add("Could you elaborate on that?");
    }
    
    /**
     * Randomly select and return one of the default responses.
     * @return     A random default response
     */
    private String pickDefaultResponse()
    {
        // Pick a random number for the index in the default response list.
        // The number will be between 0 (inclusive) and the size of the list (exclusive).
        int index = randomGenerator.nextInt(defaultResponses.size());
        return defaultResponses.get(index);
    }
    
}

