package com.darclejf.test;

import java.util.ArrayList;

import com.darclejf.models.ContestantModel;
import com.darclejf.models.ResultEnum;
import com.darclejf.models.ScoreOutputModel;
import com.darclejf.service.ScoreService;

import junit.framework.TestCase;

public class ScoreTest extends TestCase {

    public void testeOutput() {
        ContestantModel[] contestantModels = new ContestantModel[2];
        ContestantModel c1 = new ContestantModel();
        ContestantModel c2 = new ContestantModel();

        c1.setNumber(1);
        c2.setNumber(3);

        c1.addProblem(2, 10, ResultEnum.I);
        c2.addProblem(11, 11, ResultEnum.C);
        c1.addProblem(2, 19, ResultEnum.R);
        c1.addProblem(2, 21, ResultEnum.C);
        c1.addProblem(1, 25, ResultEnum.C);

        contestantModels[0] = c1;
        contestantModels[1] = c2;

        ArrayList<ScoreOutputModel> scoreWish = new ArrayList<ScoreOutputModel>();
        scoreWish.add(new ScoreOutputModel(1, 2, 66));
        scoreWish.add(new ScoreOutputModel(3, 1, 11));

        ArrayList<ScoreOutputModel> scoreResult = new ScoreService().getOutput(contestantModels);

        assertEquals(scoreWish.get(0), scoreResult.get(0));
        assertEquals(scoreWish.get(1), scoreResult.get(1));        
    }

}