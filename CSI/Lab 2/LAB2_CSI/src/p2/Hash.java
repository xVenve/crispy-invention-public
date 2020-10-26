package p2;

import org.bouncycastle.crypto.digests.GeneralDigest;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.digests.SHA512Digest;
import org.bouncycastle.util.encoders.Hex;

/**
 * Ejecuta distintas funciones resumen
 */
@SuppressWarnings("unused")
public class Hash {

	/**
	 * Establece la función resumen MD5 para el procesamiento
	 */
	public void doMD5() {}

	/**
	 * Establece la función resumen SHA1 para el procesamiento
	 */
	public void doSHA1() {
		doDigest(new SHA512Digest());
	}

	/**
	 * Gestiona un digest de un archivo
	 * @param sha512Digest
	 * @return
	 */
	protected byte[] doDigest(SHA512Digest sha512Digest) {
		byte[] fileContent = Utils.instance().doSelectFile("Select a file", "txt");
		if (fileContent != null) {
			byte[] result = digest(sha512Digest, fileContent);
			System.out.println("The hash is:" + new String(Hex.encode(result)));
			return result;
		}
		return null;
	}

	/**
	 * Realiza el procesamiento de la función resumen seleccionada
	 * @param sha512Digest
	 * @param input
	 * @return
	 */
	public byte[] digest(SHA512Digest sha512Digest, byte[] input) {
		sha512Digest.update(input, 0, input.length);

		// get the output/ digest size and hash it
		byte[] result = new byte[sha512Digest.getDigestSize()];
		sha512Digest.doFinal(result, 0);
		return result;
	}

}
