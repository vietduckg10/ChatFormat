package com.ducvn.chatformat;

import net.minecraft.network.chat.Component;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

@Mod.EventBusSubscriber(modid = ChatFormatMod.MODID)
public class ChatFormatEvents {
    private static final Map<String, String> convertMap = new HashMap<String, String>() {{
        put("$0", "\u00A70");
        put("$1", "\u00A71");
        put("$2", "\u00A72");
        put("$3", "\u00A73");
        put("$4", "\u00A74");
        put("$5", "\u00A75");
        put("$6", "\u00A76");
        put("$7", "\u00A77");
        put("$8", "\u00A78");
        put("$9", "\u00A79");
        put("$a", "\u00A7a");
        put("$b", "\u00A7b");
        put("$c", "\u00A7c");
        put("$d", "\u00A7d");
        put("$e", "\u00A7e");
        put("$f", "\u00A7f");
        put("$k", "\u00A7k");
        put("$l", "\u00A7l");
        put("$m", "\u00A7m");
        put("$n", "\u00A7n");
        put("$o", "\u00A7o");
        put("$r", "\u00A7r");
        put("$ ", "$");
    }};
    @SubscribeEvent
    public static void ConvertChatCodeToColor(ServerChatEvent event){
        if (!event.getPlayer().level.isClientSide){
            event.setMessage(FormatText(event.getMessage()));
        }
    }

    private static Component FormatText(Component component){
        String returnText = component.getString();
        for (Map.Entry<String, String> entry : convertMap.entrySet()){
            if (component.getString().indexOf(entry.getKey()) != -1){
                returnText = returnText.replace(entry.getKey(), entry.getValue());
            }
        }
        return Component.literal(returnText);
    }
}
