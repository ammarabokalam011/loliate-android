package mohamad.ammar.abu.kalam.apipresentationlibrary.responses

class LoginResponse {
    var authenticationToken: String = ""

    constructor(authenticationToken: String) {
        this.authenticationToken = authenticationToken
    }
}