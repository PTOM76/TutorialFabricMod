package com.github.ptom76.tutorialfabricmod.command;

import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

import static net.minecraft.server.command.CommandManager.*;

public class Commands {
    public static void init() {
        CommandRegistrationCallback.EVENT.register(((dispatcher, registryAccess, environment) -> dispatcher.register(
                literal("helloworld")
                        .executes(context -> helloworld(context, 1))
                        .then(argument("count", IntegerArgumentType.integer(1, 64))
                                .executes(context -> helloworld(context, context
                                        .getArgument("count", Integer.class)))
                                .then(argument("broadcast", BoolArgumentType.bool())
                                    .executes(context -> helloworld(context, context.getArgument("count", Integer.class), context
                                            .getArgument("broadcast", Boolean.class)))

                        ))
                        .then(argument("broadcast", BoolArgumentType.bool())
                                .executes(context -> helloworld(context, 1, BoolArgumentType.getBool(context, "broadcast")))))));

    }

    public static int helloworld(CommandContext<ServerCommandSource> context, int count) {
        return helloworld(context, count, false);
    }

    public static int helloworld(CommandContext<ServerCommandSource> context, int count, boolean broadcast) {
        if (context.getSource().hasPermissionLevel(1)) {
            for (int i = 0; i < count; i++) {
                if (broadcast)
                    // プレイヤー全体に送信
                    context.getSource().getServer().getPlayerManager().broadcast(Text.literal("Hello World! (" + (i + 1) + ")"), false);
                else
                    // 実行したプレイヤーに送信
                    context.getSource().sendMessage(Text.literal("Hello World! (" + (i + 1) + ")"));
            }
            return 1;
        }
        return 0;
    }
}
