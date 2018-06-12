package com.darclejf.service;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.darclejf.models.ResponseModel;

import org.eclipse.egit.github.core.Comment;
import org.eclipse.egit.github.core.Gist;
import org.eclipse.egit.github.core.GistFile;
import org.eclipse.egit.github.core.service.GistService;

/**
 * @author Darclejf
 * @version 1.00
 */
public class GitService {

    private final String filename = "scoreboard.txt";
    private final String userGit = "user";
    private final String passwordGit = "password";
    private GistService gistService;

    public GitService() {
        gistService = new GistService();
        gistService.getClient().setCredentials(this.userGit, this.passwordGit);
    }

    public ResponseModel createGist() {
        try {
            GistFile file = new GistFile();
            file.setContent("empty");

            Gist gist = new Gist();
            gist.setDescription("Contest Scoreboard");
            gist.setFiles(Collections.singletonMap(this.filename, file));
            gist = gistService.createGist(gist);
            return new ResponseModel(gist.getId(), true, null);
        } 
        catch (IOException e) {
            return new ResponseModel(null, false, String.format("I/O error: %e", e.getMessage()));
        }
        catch (Exception ex) {
            return new ResponseModel(null, false, String.format("General error: %e", ex.getMessage()));
        }
    }

    public ResponseModel updateGistFile(String content, String idGist) {
        try {
            Gist gist = gistService.getGist(idGist);
            Map<String, GistFile> files = gist.getFiles();
            GistFile file = files.get(this.filename);
            file.setFilename(this.filename);
            file.setContent(content);
            gist.setFiles(files);
            gistService.updateGist(gist);
            return new ResponseModel(gist, true, "Update Score");
        }
        catch (IOException e) {
            e.printStackTrace();
            return new ResponseModel(null, false, String.format("Not possible save new score. I/O error %e.", e.getMessage()));
        }
    }

    public ResponseModel getLastScoreContentFile(String idGist) {
        try {
            Gist gist = gistService.getGist(idGist);
            Map<String, GistFile> files = gist.getFiles();
            GistFile file = files.get(this.filename);
            return new ResponseModel(file.getContent(), true, null);
        } 
        catch (IOException e) {
            return new ResponseModel(null, false, String.format("Not possible get Score. I/O error: %e", e.getMessage()));
        }
        catch (Exception ex) {
            return new ResponseModel(null, false, String.format("Not possible get Score. General error: %e", ex.getMessage()));
        }
    } 

    public ResponseModel getGistComments(String idGist) {
        try {
            List<Comment> comments = gistService.getComments(idGist);
            return new ResponseModel(comments, true, null);
        }
        catch (IOException e) {
            return new ResponseModel(null, false, String.format("I/O error: %e", e.getMessage()));
        }
        catch (Exception ex) {
            return new ResponseModel(null, false, String.format("General error: %e", ex.getMessage()));
        }
    }
}