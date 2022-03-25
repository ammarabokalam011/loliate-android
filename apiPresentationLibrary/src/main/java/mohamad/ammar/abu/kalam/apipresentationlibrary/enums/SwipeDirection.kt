package mohamad.ammar.abu.kalam.apipresentationlibrary.enums

enum class SwipeDirection private constructor(private var value: Int) {
    all(0), left(1), right(2), none(3);

    fun getValue(): Int {
        return value
    }

    fun setValue(id: Int): SwipeDirection {
        this.value = id
        when (id) {
            0 -> return all
            1 -> return left
            2 -> return right
            3 -> return none
        }
        return all
    }
}