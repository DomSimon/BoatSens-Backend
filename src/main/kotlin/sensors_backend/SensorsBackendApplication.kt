package sensors_backend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.annotation.Id
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.relational.core.mapping.Table
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

@SpringBootApplication
class SensorsBackendApplication

fun main(args: Array<String>) {
    runApplication<SensorsBackendApplication>(*args)
}

@Service
class MessageService(val repository: MeasurementRepository) {
    fun findMessages_all(): List<Sensorclass> = repository.findMessagesAll()
    fun findMessages_24h(): List<Sensorclass> = repository.findmessages24h()
    fun findMessages_1h(): List<Sensorclass> = repository.findMessages1h()
    fun findMessages_hottest_day(): List<Sensorclass> = repository.findMessagesHottestSay()
    fun findMessages_coldest_day(): List<Sensorclass> = repository.findMessages_coldest_day()
    fun deleter(id: String): List<Sensorclass> = repository.deleter(id)

    fun post(message: Sensorclass) {
        message.sensordate = LocalDateTime.now()
        println("Put to DB: $message")
        repository.save(message)
    }

    fun put(message: Sensorclass) {
        repository.save(message)
    }

    fun findMeasurementByDate(date1: String): List<Sensorclass> {
        val parsedDate1 = LocalDate.parse(date1)
        val dayStart = LocalDateTime.of(parsedDate1, LocalTime.MIN)
        val dayEnd = LocalDateTime.of(parsedDate1, LocalTime.MAX)
        return repository.findDayMeasurementsBetweenDates(dayStart, dayEnd)
    }

    fun findDayMeasurementsBetweenDates(date1: String, date2: String): List<Sensorclass> {
        val parsedDate1 = LocalDateTime.parse(date1)
        val parsedDate2 = LocalDateTime.parse(date2)
        println(parsedDate1)
        println(parsedDate2)
        return repository.findDayMeasurementsBetweenDates(parsedDate1, parsedDate2)
    }
}

interface MeasurementRepository : CrudRepository<Sensorclass, String> {

    @Query("select * from sensordata")
    fun findMessagesAll(): List<Sensorclass>

    @Query("SELECT * FROM sensordata WHERE sensordate BETWEEN NOW() - INTERVAL '24 HOURS' AND NOW() ")
    fun findmessages24h(): List<Sensorclass>

    @Query("SELECT * FROM sensordata WHERE sensordate BETWEEN NOW() - INTERVAL '1 HOURS' AND NOW() ")
    fun findMessages1h(): List<Sensorclass>

    @Query("SELECT * FROM sensordata WHERE sensorvalue = ( SELECT MAX(sensorvalue) FROM sensordata) AND sensortype = 'temperature' LIMIT 1 ")
    fun findMessagesHottestSay(): List<Sensorclass>

    @Query("SELECT * FROM sensordata WHERE sensorvalue = ( SELECT MIN(sensorvalue) FROM sensordata) AND sensortype = 'temperature' LIMIT 1 ")
    fun findMessages_coldest_day(): List<Sensorclass>

    @Query("SELECT * FROM sensordata WHERE sensordate BETWEEN :date1 AND :date2 ")
    fun findDayMeasurementsBetweenDates(
        @Param("date1") date1: LocalDateTime,
        @Param("date2") date2: LocalDateTime
    ): List<Sensorclass>

    @Query("DELETE FROM sensordata WHERE id = CAST(:idt as int) ;")
    fun deleter(
        @Param("idt") idt: String
    ): List<Sensorclass>
}

@Table("sensordata")
data class Sensorclass(
    @Id var id: String?,
    val sensorname: String?,
    var sensordate: LocalDateTime?,
    val sensorvalue: String?,
    val sensortype: String?
)


