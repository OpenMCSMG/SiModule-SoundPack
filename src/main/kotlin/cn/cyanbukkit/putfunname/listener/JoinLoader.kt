package cn.cyanbukkit.putfunname.listener

import cn.cyanbukkit.soundpack.cyanlib.launcher.CyanPluginLauncher.cyanPlugin
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerResourcePackStatusEvent

object JoinLoader : Listener {

    @EventHandler
    fun onJoin(event: PlayerJoinEvent) {
        // 发送资源包
        val p = event.player
        p.setResourcePack(cyanPlugin.config.getString("url"))
    }

    @EventHandler
    fun ex(e: PlayerResourcePackStatusEvent) {
        val p = e.player
        when (e.status) {
            PlayerResourcePackStatusEvent.Status.DECLINED -> {
                p.kickPlayer("请接受资源包")
            }
            PlayerResourcePackStatusEvent.Status.FAILED_DOWNLOAD -> {
                p.kickPlayer("资源包下载失败")
            }
            PlayerResourcePackStatusEvent.Status.ACCEPTED -> {
                p.sendMessage("资源包下载成功")
            }
            PlayerResourcePackStatusEvent.Status.SUCCESSFULLY_LOADED -> {
                p.sendMessage("资源包加载成功")
            }
            else -> {
                p.kickPlayer("未知错误")
            }
        }

    }

}