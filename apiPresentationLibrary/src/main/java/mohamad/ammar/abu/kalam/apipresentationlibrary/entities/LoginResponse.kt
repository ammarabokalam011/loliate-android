package mohamad.ammar.abu.kalam.apipresentationlibrary.entities

class LoginResponse {
    var authenticationToken: String = ""

    constructor(authenticationToken: String, refreshToken: String) {
        this.authenticationToken = authenticationToken
    }
}