package csc.com.br.dataprovider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import csc.com.br.statemachine.Command;
import csc.com.br.statemachine.ICommand;
import csc.com.br.statemachine.IState;
import csc.com.br.statemachine.State;

public class FileDataProvider implements IDataProvider {

	public IState getInitialState() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ICommand> getProgram() {
		// TODO Auto-generated method stub
		return null;
	}

	public void getMachine() {
		Map<IState, HashMap<ICommand, IState>> machine = new HashMap<IState, HashMap<ICommand, IState>>();	
		File file = new File("resources/StateMachine.txt");
        BufferedReader bufferedReader;
        String line;

        try {
            bufferedReader = new BufferedReader(new FileReader(file));

            while ((line = bufferedReader.readLine()) != null) {
                String[] tokens = line.split("\\s+", 3);
                
                State mainState = new State(tokens[0]);
        		State nextState = new State(tokens[1]);
        		ICommand command = new Command(token[2]);
        		
        		mainState.addNextState(command, nextState);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}