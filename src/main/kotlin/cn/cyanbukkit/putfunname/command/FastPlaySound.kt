package cn.cyanbukkit.putfunname.command

import org.bukkit.command.Command
import org.bukkit.command.CommandSender

object FastPlaySound : Command("fps") {
    override fun execute(p0: CommandSender, p1: String, p2: Array< String>): Boolean {
        // fps <玩家>  <声音>  [音量]  [音调]
        try {
            when (p2.size) {
                2 -> {
                    p0.server.getPlayer(p2[0])?.playSound(p0.server.getPlayer(p2[0])?.location, p2[1], 1f, 1f)
                }
                3 -> {
                    p0.server.getPlayer(p2[0])?.playSound(p0.server.getPlayer(p2[0])?.location, p2[1], p2[2].toFloat(), 1f)
                }
                4 -> {
                    p0.server.getPlayer(p2[0])?.playSound(p0.server.getPlayer(p2[0])?.location, p2[1], p2[2].toFloat(), p2[3].toFloat())
                }
            }
        } catch (e: Exception) {
            p0.sendMessage("参数错误")
        }
        return true
    }
}