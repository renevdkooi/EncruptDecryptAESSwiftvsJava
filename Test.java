public void test()
{
    try {

        String input = "what is this about?";

        String algorithm = "AES/CBC/PKCS5Padding";
        String cipherText = AESUtil.encrytData(algorithm, "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx", "xxxxxxxxxxxxxxxx", input);
        String plainText = AESUtil.decryptData(algorithm, "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx", "xxxxxxxxxxxxxxxx", cipherText);

        Log.e("TEST","cipherText: " + cipherText);
        Log.e("TEST","plainText: " + plainText);

    } catch (Exception e)
    {
        Log.e("TEST","Exception: " + e.getLocalizedMessage());
    }
}
