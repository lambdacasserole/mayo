# Mayo
Diffie-Hellman key exchange utility for Java on Maven.

Very tiny library for generating Diffie-Hellman private keys, public keys and shared secrets using Java's `BigInteger` type. Use it like this:

```
// Generate Alice's key pair.
BigInteger alicePrivateKey = DiffieHellmanKeyGenerator.generatePrivateKey();
BigInteger alicePublicKey = DiffieHellmanKeyGenerator.generatePublicKey(alicePrivateKey);

// Generate Bob's key pair.
BigInteger bobPrivateKey = DiffieHellmanKeyGenerator.generatePrivateKey();
BigInteger bobPublicKey = DiffieHellmanKeyGenerator.generatePublicKey(bobPrivateKey);

// Arrive at shared secret.
BigInteger aliceSharedSecret = DiffieHellmanKeyGenerator.generateSharedKey(bobPublicKey, alicePrivateKey);
BigInteger bobSharedSecret = DiffieHellmanKeyGenerator.generateSharedKey(alicePublicKey, bobPrivateKey);

assertEquals(aliceSharedSecret, bobSharedSecret); // Alice and Bob should have arrived at same secret.
```

Feel free to transmit the public keys in the clear. By the end of the handshake you'll both have arrived at the same secret to use with  symmetric encryption, without transmitting the secret in the clear. Mayo uses a 1536-bit prime.

## Installation
You can pull this package into your Maven project straight from here using JitPack. Add JitPack as a repository first:

```
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

Then add a dependency on Mayo:

```
<dependencies>
    <dependency>
        <groupId>com.github.lambdacasserole</groupId>
        <artifactId>mayo</artifactId>
        <version>v1.0</version>
    </dependency>
</dependencies>
```

## Limitations
I'm not a cryptographer and for all I know there's a horrible mistake in this library that's going to open it up to a trillion different attacks. Use a time-tested and reliable implementation over Mayo any day.

Also, there are a [number of well-known attacks](https://weakdh.org/) on Diffie-Hellman key exchanges. 

## Contributing
For most intents and purposes, Mayo is considered to fulfil its original use case. Bug fixes and suggestions are welcome, however, from any member of the community.
