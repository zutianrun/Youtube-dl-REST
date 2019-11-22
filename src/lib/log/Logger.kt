package lib.log

class Logger(private val name: String = "Logger") {
	fun log(_msg: Any?, title: String = "") {
		val msg = _msg ?.toString() ?: "[null]"

		val trace: Array<StackTraceElement>?  = Thread.currentThread().stackTrace

		if (trace == null || trace.size < 3) return println("Logger@$name $title -> $msg")

		val caller = trace[3]

		with (caller) {
			var output = "Logger@$name ~ $fileName($lineNumber) ~ $className.$methodName(): "
			output += if (title.trim() != "") "$title -> $msg" else msg
			println(output)
		}
	}
}
