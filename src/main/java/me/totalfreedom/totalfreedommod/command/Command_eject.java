package me.totalfreedom.totalfreedommod.command;

import me.totalfreedom.totalfreedommod.rank.Rank;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

@CommandPermissions(level = Rank.SUPER_ADMIN, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "Eject everything off of you.", usage = "/<command>")
public class Command_eject extends FreedomCommand
{

    @Override
    public boolean run(CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {

        List<String> names = new ArrayList();

        for (Entity entity : playerSender.getPassengers())
        {
            names.add(entity.getName());
        }

        msg("Ejecting " + StringUtils.join(names, ", ") + ".", ChatColor.GREEN);
        playerSender.eject();

        return true;
    }
}