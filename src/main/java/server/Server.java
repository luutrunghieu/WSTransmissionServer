package server;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.Checksum;
import java.util.zip.GZIPInputStream;

import org.apache.commons.lang3.SerializationUtils;
import org.rapidoid.http.Req;
import org.rapidoid.setup.On;

import spark.utils.IOUtils;

public class Server {
	public static void main(String[] args) {
		On.address("192.168.23.59").port(9999);
		On.post("/postgzip").json((Req req) -> {

			// lay data tu request
			byte[] bytes = req.body();
			// kiem tra checksum
			String ChecksumSend = req.param("Checksum");
			String ChecksumReCal = server.Checksum.CalChecksum(bytes);
			// neu dung checksum thi deserialize du lieu, ko dung thi yeu cau
			// gui lai
			if (ChecksumSend.equals(ChecksumReCal)) {
				byte[] decompressData = unGzip(bytes);

				// deserialize
				Model model = SerializationUtils.deserialize(decompressData);
				System.out.println(model.getId());
				return "accept";
			}

			return "resend";
		});
	}
	public static byte[] unGzip(byte[] bytes){
        //tao byteStream va giai nen du lieu, copy vao byteStream
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        try{
            IOUtils.copy(new GZIPInputStream(new ByteArrayInputStream(bytes)), byteStream);
        }catch (IOException e){
            e.printStackTrace();
        }
        byte[] decompressData = byteStream.toByteArray();
        return decompressData;
    }
}
