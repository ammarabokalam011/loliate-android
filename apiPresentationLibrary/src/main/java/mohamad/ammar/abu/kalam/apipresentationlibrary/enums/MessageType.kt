package mohamad.ammar.abu.kalam.apipresentationlibrary.enums

enum class MessageType(val type: Int) {
    Success(1),
    Error(2),
    Warning(3),
    Info(4),
    UnAuthorize(5)
}