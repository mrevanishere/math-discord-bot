package com.github.mrevanishere;
// Ctrl shift o to load gradle changes in IDEA
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

public class Main {
    public static void main(String[] args) {
        // Bot's token
        String token = "";
        DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();

        api.addMessageCreateListener(event -> {
            String input = event.getMessageContent();
            int n = input.length();
            String command = getFirstWord(input);
            if (event.getMessageContent().equalsIgnoreCase("!ping")) {
                event.getChannel().sendMessage("Pong!");
            }
            if (command.equals("!calc")) {
                event.getChannel().sendMessage("Calculating ...");
            }
        });

        // Add listener
        // Print Invite URL of Bot
    }

     static private String getFirstWord(String text) {
      int index = text.indexOf(' ');

      if (index > -1) { // Check if there is more than one word.

        return text.substring(0, index).trim(); // Extract first word.

      } else {

        return text; // Text is the first word itself.
      }
    }
}
