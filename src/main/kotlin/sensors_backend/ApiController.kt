package sensors_backend

import org.springframework.web.bind.annotation.*


@RestController
class ApiController(val service: MessageService) {
    @GetMapping("/api/all")
    fun index(): List<Sensorclass> {
        return service.findMessages_all()
    }

    @GetMapping("/api/last24h")
    fun index_24h(): List<Sensorclass> {
        return service.findMessages_24h()
    }

    @GetMapping("/api/last1h")
    fun index_1h(): List<Sensorclass> {
        return service.findMessages_1h()
    }

    @GetMapping("/api/hottest_day")
    fun index_hottest_day(): List<Sensorclass> {
        return service.findMessages_hottest_day()
    }

    @GetMapping("/api/coldest_day")
    fun index_coldest_day(): List<Sensorclass> {
        return service.findMessages_coldest_day()
    }

    @GetMapping("/api/day/{date}")
    @ResponseBody
    fun index_day(@PathVariable date: String): List<Sensorclass> {
        return service.findMeasurementByDate(date)
    }


    @GetMapping("/api/between/{date1}/{date2}")
    @ResponseBody
    fun index_between_days(@PathVariable date1: String, @PathVariable date2: String): List<Sensorclass> {
        return service.findDayMeasurementsBetweenDates(date1, date2)
    }

    @GetMapping("/api/delete/{id}")
    fun index_delete(@PathVariable id: String): List<Sensorclass> {
        return service.deleter(id)
    }


    @PostMapping("/postmap")
    fun post(@RequestBody message: Sensorclass) {
        return service.post(message)
    }

    @PutMapping("/putmap")
    fun put(@RequestBody message: Sensorclass) {
        service.put(message)
    }

}