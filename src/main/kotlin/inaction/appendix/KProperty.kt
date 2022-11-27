package inaction.appendix

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class BarDelegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        println("thisRef = ${thisRef}")
        println("property.name = ${property.name}")
        return 100
    }
}

val y: Int by BarDelegate()

fun main() {
    val x: Int by BarDelegate()
    println("x = $x y = $y")

    val debugRemoteConfig = RemoteConfig(true)
    println("목 객체로 톰캣 설정 가져옴: ${debugRemoteConfig.tomcat}")
    println("목 객체로 아파치 설정 가져옴: ${debugRemoteConfig.httpd}")

    val realRemoteConfig = RemoteConfig(false)
    println("실제 객체로 톰캣 설정 가져옴: ${realRemoteConfig.tomcat}")
    println("실제 객체로 아파치 설정 가져옴: ${realRemoteConfig.httpd}")
}

interface ConfigService {
    fun getConfig(section: String): String
}

class RealConfigService(val addr: String) : ConfigService {
    override fun getConfig(section: String): String {
        return "$addr 에서 읽은 JSON"
    }
}

class MockConfigService(val addr: String) : ConfigService {
    override fun getConfig(section: String): String {
        return "테스트 JSON"
    }
}

class ConfigServiceDelegateProvider(
    val server: String, val port: Int = 8880,
    debug: Boolean = false
) {
    val service: ConfigService

    init {
        service = if (debug)
            MockConfigService("$server:$port")
        else
            RealConfigService("$server:$port")
    }
    operator fun provideDelegate(
        thisRef: RemoteConfig,
        prop: KProperty<*>
    ) : ReadOnlyProperty<RemoteConfig, String> {
        if(prop.name == "tomcat") {
            return object: ReadOnlyProperty<RemoteConfig, String> {
                override fun getValue(thisRef: RemoteConfig, property: KProperty<*>) :
                    String {
                    return service.getConfig(prop.name)
                }
            }
        } else if(prop.name == "httpd" || prop.name == "apache") {
            return object: ReadOnlyProperty<RemoteConfig, String> {
                override fun getValue(thisRef: RemoteConfig, property: KProperty<*>) :
                    String {
                    return service.getConfig(prop.name)
                }
            }
        } else throw IllegalArgumentException("prop name should be tomcat or httpd or apache")
    }
}

class RemoteConfig(val debug: Boolean) {
    val tomcat by ConfigServiceDelegateProvider("111.111.11.1", debug=this.debug)
    val httpd by ConfigServiceDelegateProvider("111.111.11.1", debug=this.debug)
}

