package com.darclejf.service;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;

import com.darclejf.models.ContestantModel;
import com.darclejf.models.ResponseModel;
import com.darclejf.models.ResultEnum;
import com.darclejf.models.ScoreInputModel;
import com.darclejf.models.ScoreOutputModel;

/**
 * @author DarcleJF
 * @version 1.00
 */
public class ScoreService {

    public ResponseModel ReadInput(ScoreInputModel input) {
        ContestantModel[] contestants = new ContestantModel[100];
        String line = "";
        String message = "";
        
        try {
            InputStream streamReader = new ByteArrayInputStream(input.getContentFile().getBytes(StandardCharsets.UTF_8));
            BufferedReader reader = new BufferedReader(new InputStreamReader(streamReader, "UTF-8"));
            line = reader.readLine();            
            String[] lineSplit;
            int numberCases = Integer.parseInt(line);
            int indexContestant;

            ContestantModel contestant;

            while (numberCases > -1) {
                line = reader.readLine();
                
                if (line == null) {
                    break;
                }

                if (line.length() == 0) {
                    continue;
                }

                if (line.length() == 1) {
                    numberCases--;
                    continue;
                }

                lineSplit = line.split(" ");

                indexContestant = this.stringToInt(lineSplit[0])-1;

                contestant = contestants[indexContestant];
                if (contestant == null) {
                    contestant = new ContestantModel();
                    contestant.setNumber(this.stringToInt(lineSplit[0]));
                }

                contestant.addProblem(
                    this.stringToInt(lineSplit[1]), 
                    this.stringToInt(lineSplit[2]), 
                    this.stringToResultEnum(lineSplit[3]));

                contestants[indexContestant] = contestant;
            }

        }
        catch (IOException e) {
            e.printStackTrace();
            return new ResponseModel(null, false, "Not possible save new score. Format of input is invalid.");
        }
        catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            return new ResponseModel(null, false, "Invalid number of contestant.");
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseModel(null, false, "Not possible save new score. Please try again");
        } 

        ArrayList<ScoreOutputModel> score = this.getOutput(contestants); 
        return this.saveScore(score, input.getIdGist());
    }

    public ArrayList<ScoreOutputModel> getOutput(ContestantModel[] contestants) {
        ArrayList<ScoreOutputModel> result = new ArrayList<ScoreOutputModel>();
        for (ContestantModel contestant : contestants) {
            if (contestant != null) {
                result.add(new ScoreOutputModel(contestant.getNumber(), contestant.getSolveds(), contestant.getTimePenalties()));
            }
        }

        Collections.sort(result);
        return result;
    }

    private ResponseModel saveScore(ArrayList<ScoreOutputModel> score, String idGist) {
        StringBuilder sb = new StringBuilder();
        for (ScoreOutputModel item : score) {
            sb.append(item.toString());
        }
        GitService service = new GitService();
        return service.updateGistFile(sb.toString(), idGist);
    }

    private int stringToInt(String s) {
        return Integer.parseInt(s);
    }

    private ResultEnum stringToResultEnum(String s) {
        return ResultEnum.valueOf(s);
    }
}