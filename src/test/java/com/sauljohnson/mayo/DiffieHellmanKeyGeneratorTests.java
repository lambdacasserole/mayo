package com.sauljohnson.mayo;

import junit.framework.TestCase;

import java.math.BigInteger;

/**
 * Unit tests for the {@link DiffieHellmanKeyGenerator} class.
 *
 * @version 1.0 06 June 2016
 * @author  Saul Johnson
 */
public class DiffieHellmanKeyGeneratorTests extends TestCase {

    public void testGenerateSharedKey() {
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
    }
}
