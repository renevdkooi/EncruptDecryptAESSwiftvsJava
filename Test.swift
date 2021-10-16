        let key = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"    // length == 32
        let iv = "xxxxxxxxxxxxxxxx"                     // length == 16
        let s = "what is this about?"
        let enc = try! s.aesEncrypt(key: key, iv: iv)
        let dec = try! enc.aesDecrypt(key: key, iv: iv)
        print(s) // string to encrypt
        print("ID: enc:\(enc)") // 2r0+KirTTegQfF4wI8rws0LuV8h82rHyyYz7xBpXIpM=
        print("ID: dec:\(dec)") // string to encrypt
        print("ID:  \(s == dec)") // true
        
