package dataset.model.path;

import java.io.File;

import static dataset.minimize.ProjectMinimizer.METADATA_DIR;
import static dataset.minimize.ProjectMinimizer.METADATA_FILE_NAME;

/**
 * Obtains paths to buggy and working project from dataset for mutation framework
 */
public class MutationFrameworkPathConfiguration extends PathConfiguration {
    private static final String BUGGY_DIR = "bug";
    private static final String WORKING_DIR = "fix";
    private static final String STORAGE_FILE = "createdBugs.json";
    public MutationFrameworkPathConfiguration(String repoPath) {
        super(repoPath);
    }

    @Override
    public String getBugPath(String projectName, String bugId) {
        return String.join(File.separator, repoPath, projectName, bugId);
    }
    @Override
    public String getBuggyPath(String projectName, String bugId) {
        return String.join(File.separator, repoPath, projectName, bugId, BUGGY_DIR);
    }

    @Override
    public String getFixPath(String projectName, String bugId) {
        return String.join(File.separator, repoPath, projectName, WORKING_DIR);
    }

    @Override
    public String getRelativeBuggyPath(String projectName, String bugId) {
        return String.join(File.separator, projectName, bugId, BUGGY_DIR);
    }

    @Override
    public String getRelativeFixPath(String projectName, String bugId) {
        return String.join(File.separator, projectName, WORKING_DIR);
    }

    @Override
    public String getMetadataPath(String projectName, String bugId) {
        return String.join(File.separator, repoPath, projectName, bugId, METADATA_DIR);
    }

    @Override
    public String getRelativeMetadataPath(String projectName, String bugId) {
        return String.join(File.separator, projectName, bugId, METADATA_DIR);
    }

    @Override
    public String getRestorationInstructionsPath(String projectName, String bugId) {
        return String.join(File.separator, getMetadataPath(projectName, bugId), METADATA_FILE_NAME);
    }

    @Override
    public String getRelativeRestorationInstructionsPath(String projectName, String bugId) {
        return String.join(File.separator, projectName, bugId, METADATA_DIR, METADATA_FILE_NAME);
    }

    @Override
    public String getStoragePath(String projectName) {
        return String.join(File.separator, repoPath, projectName, STORAGE_FILE);
    }

}
