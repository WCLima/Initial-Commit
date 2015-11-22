package beaconManagement.tcc.scheduler;

import java.io.File;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.PutObjectRequest;

public class BackUpToAmazonS3 {

	private static final Logger LOOGER = Logger
			.getLogger(BackUpToAmazonS3.class);

	private static String bucketName = "*** Provide bucket name ***";
	private static String keyName = "*** Provide key ***";
	private static String uploadFileName = "*** Provide file name ***";

	@Scheduled
	public void BackUpToS3() {
		AmazonS3 s3client = new AmazonS3Client(new ProfileCredentialsProvider());
		try {
			File file = new File(uploadFileName);
			s3client.putObject(new PutObjectRequest(bucketName, keyName, file));

		} catch (AmazonServiceException ase) {
			LOOGER.error("Error Message:    " + ase.getMessage());
			LOOGER.error("HTTP Status Code: " + ase.getStatusCode());
			LOOGER.error("AWS Error Code:   " + ase.getErrorCode());
			LOOGER.error("Error Type:       " + ase.getErrorType());
			LOOGER.error("Request ID:       " + ase.getRequestId());
		} catch (AmazonClientException ace) {
			LOOGER.error("Error Message: " + ace.getMessage());
		}
	}
}
