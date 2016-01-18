package org.red5.demos.oflaDemo;

import org.red5.server.api.scope.IScope;
import org.red5.server.api.stream.IStreamFilenameGenerator;
import org.red5.server.api.stream.IStreamFilenameGenerator.GenerationType;

public class CustomFilenameGenerator implements IStreamFilenameGenerator {
	public String recordPath;
	public String playbackPath;

	public String generateFilename(IScope scope, String name,
			IStreamFilenameGenerator.GenerationType type) {
		return generateFilename(scope, name, null, type);
	}

	public String generateFilename(IScope scope, String name, String extension,
			IStreamFilenameGenerator.GenerationType type) {
		String filename;
		if (type == IStreamFilenameGenerator.GenerationType.RECORD)
			filename = this.recordPath + name;
		else {
			filename = this.playbackPath + name;
		}
		if (extension != null) {
			filename = filename + extension;
		}
		return filename;
	}

	public void setRecordPath(String path) {
		this.recordPath = path;
	}

	public void setPlaybackPath(String path) {
		this.playbackPath = path;
	}

	public boolean resolvesToAbsolutePath() {
		return true;
	}
}