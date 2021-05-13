from __future__ import print_function
# bustersAgents.py
# ----------------
# Licensing Information:  You are free to use or extend these projects for
# educational purposes provided that (1) you do not distribute or publish
# solutions, (2) you retain this notice, and (3) you provide clear
# attribution to UC Berkeley.
#
# Attribution Information: The Pacman AI projects were developed at UC Berkeley.
# The core projects and autograders were primarily created by John DeNero
# (denero@cs.berkeley.edu) and Dan Klein (klein@cs.berkeley.edu).
# Student side autograding was added by Brad Miller, Nick Hay, and
# Pieter Abbeel (pabbeel@cs.berkeley.edu).


from builtins import range
from builtins import object
import util
from game import Agent
from game import Directions
from keyboardAgents import KeyboardAgent
import inference
import busters
import os
import numpy
import math
import time
# from wekaI import Weka


class NullGraphics(object):
    "Placeholder for graphics"
    def initialize(self, state, isBlue = False):
        pass
    def update(self, state):
        pass
    def pause(self):
        pass
    def draw(self, state):
        pass
    def updateDistributions(self, dist):
        pass
    def finish(self):
        pass

class KeyboardInference(inference.InferenceModule):
    """
    Basic inference module for use with the keyboard.
    """
    def initializeUniformly(self, gameState):
        "Begin with a uniform distribution over ghost positions."
        self.beliefs = util.Counter()
        for p in self.legalPositions: self.beliefs[p] = 1.0
        self.beliefs.normalize()

    def observe(self, observation, gameState):
        noisyDistance = observation
        emissionModel = busters.getObservationDistribution(noisyDistance)
        pacmanPosition = gameState.getPacmanPosition()
        allPossible = util.Counter()
        for p in self.legalPositions:
            trueDistance = util.manhattanDistance(p, pacmanPosition)
            if emissionModel[trueDistance] > 0:
                allPossible[p] = 1.0
        allPossible.normalize()
        self.beliefs = allPossible

    def elapseTime(self, gameState):
        pass

    def getBeliefDistribution(self):
        return self.beliefs


class BustersAgent(object):
    "An agent that tracks and displays its beliefs about ghost positions."

    def __init__( self, index = 0, inference = "ExactInference", ghostAgents = None, observeEnable = True, elapseTimeEnable = True):
        inferenceType = util.lookup(inference, globals())
        self.inferenceModules = [inferenceType(a) for a in ghostAgents]
        self.observeEnable = observeEnable
        self.elapseTimeEnable = elapseTimeEnable
        # self.weka = Weka()
        # self.weka.start_jvm()

    def registerInitialState(self, gameState):
        "Initializes beliefs and inference modules"
        import __main__
        self.display = __main__._display
        for inference in self.inferenceModules:
            inference.initialize(gameState)
        self.ghostBeliefs = [inf.getBeliefDistribution() for inf in self.inferenceModules]
        self.firstMove = True

    def observationFunction(self, gameState):
        "Removes the ghost states from the gameState"
        agents = gameState.data.agentStates
        gameState.data.agentStates = [agents[0]] + [None for i in range(1, len(agents))]
        return gameState

    def getAction(self, gameState):
        "Updates beliefs, then chooses an action based on updated beliefs."
        #for index, inf in enumerate(self.inferenceModules):
        #    if not self.firstMove and self.elapseTimeEnable:
        #        inf.elapseTime(gameState)
        #    self.firstMove = False
        #    if self.observeEnable:
        #        inf.observeState(gameState)
        #    self.ghostBeliefs[index] = inf.getBeliefDistribution()
        #self.display.updateDistributions(self.ghostBeliefs)
        return self.chooseAction(gameState)

    def chooseAction(self, gameState):
        "By default, a BustersAgent just stops.  This should be overridden."
        return Directions.STOP

class BustersKeyboardAgent(BustersAgent, KeyboardAgent):
    "An agent controlled by the keyboard that displays beliefs about ghost positions."

    def __init__(self, index = 0, inference = "KeyboardInference", ghostAgents = None):
        KeyboardAgent.__init__(self, index)
        BustersAgent.__init__(self, index, inference, ghostAgents)

    def getAction(self, gameState):
        return BustersAgent.getAction(self, gameState)

    def chooseAction(self, gameState):
        return KeyboardAgent.getAction(self, gameState)

    def printLineData(self, gameState, gameState2):
        return str(gameState.getPacmanPosition()[0]) + "," + str(gameState.getPacmanPosition()[1]) + "," + str(numpy.count_nonzero(gameState.getLivingGhosts())) + "," + str(min(x for x in gameState.data.ghostDistances if x is not None)) + "," + str(gameState.getScore()) + "," + str(gameState2.getPacmanPosition()[0]) + "," + str(gameState2.getPacmanPosition()[1]) + "," + str(numpy.count_nonzero(gameState2.getLivingGhosts())) + "," + str(gameState2.getScore()) + "," +  str(gameState.data.agentStates[0].getDirection())

from distanceCalculator import Distancer
from game import Actions
from game import Directions
import random, sys

'''Random PacMan Agent'''
class RandomPAgent(BustersAgent):

    def registerInitialState(self, gameState):
        BustersAgent.registerInitialState(self, gameState)
        self.distancer = Distancer(gameState.data.layout, False)

    ''' Example of counting something'''
    def countFood(self, gameState):
        food = 0
        for width in gameState.data.food:
            for height in width:
                if(height == True):
                    food = food + 1
        return food

    ''' Print the layout'''
    def printGrid(self, gameState):
        table = ""
        ##print(gameState.data.layout) ## Print by terminal
        for x in range(gameState.data.layout.width):
            for y in range(gameState.data.layout.height):
                food, walls = gameState.data.food, gameState.data.layout.walls
                table = table + gameState.data._foodWallStr(food[x][y], walls[x][y]) + ","
        table = table[:-1]
        return table

    def chooseAction(self, gameState):
        move = Directions.STOP
        legal = gameState.getLegalActions(0) ##Legal position from the pacman
        move_random = random.randint(0, 3)
        if   ( move_random == 0 ) and Directions.WEST in legal:  move = Directions.WEST
        if   ( move_random == 1 ) and Directions.EAST in legal: move = Directions.EAST
        if   ( move_random == 2 ) and Directions.NORTH in legal:   move = Directions.NORTH
        if   ( move_random == 3 ) and Directions.SOUTH in legal: move = Directions.SOUTH
        return move

class GreedyBustersAgent(BustersAgent):
    "An agent that charges the closest ghost."

    def registerInitialState(self, gameState):
        "Pre-computes the distance between every two points."
        BustersAgent.registerInitialState(self, gameState)
        self.distancer = Distancer(gameState.data.layout, False)

    def chooseAction(self, gameState):
        """
        First computes the most likely position of each ghost that has
        not yet been captured, then chooses an action that brings
        Pacman closer to the closest ghost (according to mazeDistance!).

        To find the mazeDistance between any two positions, use:
          self.distancer.getDistance(pos1, pos2)

        To find the successor position of a position after an action:
          successorPosition = Actions.getSuccessor(position, action)

        livingGhostPositionDistributions, defined below, is a list of
        util.Counter objects equal to the position belief
        distributions for each of the ghosts that are still alive.  It
        is defined based on (these are implementation details about
        which you need not be concerned):

          1) gameState.getLivingGhosts(), a list of booleans, one for each
             agent, indicating whether or not the agent is alive.  Note
             that pacman is always agent 0, so the ghosts are agents 1,
             onwards (just as before).

          2) self.ghostBeliefs, the list of belief distributions for each
             of the ghosts (including ghosts that are not alive).  The
             indices into this list should be 1 less than indices into the
             gameState.getLivingGhosts() list.
        """
        pacmanPosition = gameState.getPacmanPosition()
        legal = [a for a in gameState.getLegalPacmanActions()]
        livingGhosts = gameState.getLivingGhosts()
        livingGhostPositionDistributions = \
            [beliefs for i, beliefs in enumerate(self.ghostBeliefs)
             if livingGhosts[i+1]]
        return Directions.EAST

class BasicAgentAA(BustersAgent):

    def registerInitialState(self, gameState):
        BustersAgent.registerInitialState(self, gameState)
        self.distancer = Distancer(gameState.data.layout, False)
        self.countActions = 0

    ''' Example of counting something'''
    def countFood(self, gameState):
        food = 0
        for width in gameState.data.food:
            for height in width:
                if(height == True):
                    food = food + 1
        return food

    ''' Print the layout'''
    def printGrid(self, gameState):
        table = ""
        #print(gameState.data.layout) ## Print by terminal
        for x in range(gameState.data.layout.width):
            for y in range(gameState.data.layout.height):
                food, walls = gameState.data.food, gameState.data.layout.walls
                table = table + gameState.data._foodWallStr(food[x][y], walls[x][y]) + ","
        table = table[:-1]
        return table

    def printInfo(self, gameState):
        print("---------------- TICK ", self.countActions, " --------------------------")
        # Map size
        width, height = gameState.data.layout.width, gameState.data.layout.height
        print("Width: ", width, " Height: ", height)
        # Pacman position
        print("Pacman position: ", gameState.getPacmanPosition())
        # Legal actions for Pacman in current position
        print("Legal actions: ", gameState.getLegalPacmanActions())
        # Pacman direction
        print("Pacman direction: ", gameState.data.agentStates[0].getDirection())
        # Number of ghosts
        print("Number of ghosts: ", gameState.getNumAgents() - 1)
        # Alive ghosts (index 0 corresponds to Pacman and is always false)
        print("Living ghosts: ", gameState.getLivingGhosts())
        # Ghosts positions
        print("Ghosts positions: ", gameState.getGhostPositions())
        # Ghosts directions
        print("Ghosts directions: ", [gameState.getGhostDirections().get(i) for i in range(0, gameState.getNumAgents() - 1)])
        # Manhattan distance to ghosts
        print("Ghosts distances: ", gameState.data.ghostDistances)
        # Pending pac dots
        print("Pac dots: ", gameState.getNumFood())
        # Manhattan distance to the closest pac dot
        print("Distance nearest pac dots: ", gameState.getDistanceNearestFood())
        # Map walls
        print("Map:")
        print( gameState.getWalls())
        # Score
        print("Score: ", gameState.getScore())


    def chooseAction(self, gameState):
        # self.countActions = self.countActions + 1
        # self.printInfo(gameState)
        move = Directions.STOP
        legal = gameState.getLegalActions(0)  # Legal position from the pacman

        # pos = 0
        # minlocal = 999
        # iteracion = 0
        # alive_ghosts = gameState.getLivingGhosts()
        # del alive_ghosts[0]
        # for index in gameState.data.ghostDistances:
        #     if index is not None and index < minlocal and alive_ghosts[iteracion] == True:
        #         minlocal = index
        #         pos = iteracion
        #     iteracion += 1

        # position_ghost = gameState.getGhostPositions()[pos]
        #
        # if (position_ghost[0] < gameState.getPacmanPosition()[0]) and Directions.WEST in legal: move = Directions.WEST
        # elif (position_ghost[0] > gameState.getPacmanPosition()[0]) and Directions.EAST in legal: move = Directions.EAST
        # elif (position_ghost[0] == gameState.getPacmanPosition()[0]) and Directions.EAST in legal: move = Directions.EAST
        #
        # if (position_ghost[1] > gameState.getPacmanPosition()[1]) and Directions.NORTH in legal: move = Directions.NORTH
        # elif (position_ghost[1] < gameState.getPacmanPosition()[1]) and Directions.SOUTH in legal: move = Directions.SOUTH

        x = [gameState.getPacmanPosition()[0],
        gameState.getPacmanPosition()[1],
        numpy.count_nonzero(gameState.getLivingGhosts()),
        min(x for x in gameState.data.ghostDistances if x is not None)]

        # x = [gameState.getPacmanPosition()[0],
        # gameState.getPacmanPosition()[1],
        # numpy.count_nonzero(gameState.getLivingGhosts()),
        # gameState.getScore()]

        move = self.weka.predict("./J48.model",x,"./training_keyboardPython.arff")
        if move not in legal or move == Directions.STOP:
            condition = 0
            while condition == 0:
                move_random = random.randint(0, 3)
                if   ( move_random == 0 ) and Directions.WEST in legal: move = Directions.WEST
                if   ( move_random == 1 ) and Directions.EAST in legal: move = Directions.EAST
                if   ( move_random == 2 ) and Directions.NORTH in legal: move = Directions.NORTH
                if   ( move_random == 3 ) and Directions.SOUTH in legal: move = Directions.SOUTH
                if   move in legal: condition = 1
        return move

    def printLineData(self, gameState, gameState2):
        return str(
        gameState.getPacmanPosition()[0]) + "," + str(
        gameState.getPacmanPosition()[1]) + "," + str(
        numpy.count_nonzero(gameState.getLivingGhosts())) + "," + str(
        min(x for x in gameState.data.ghostDistances if x is not None)) + "," + str(
        gameState.getScore()) + "," + str(
        gameState2.getPacmanPosition()[0]) + "," + str(
        gameState2.getPacmanPosition()[1]) + "," + str(
        numpy.count_nonzero(gameState2.getLivingGhosts())) + "," + str(
        gameState2.getScore()) + "," +  str(
        gameState.data.agentStates[0].getDirection())

    # def printLineData(self, gameState, gameState2):
    #     return str(
    #     gameState.getPacmanPosition()[0]) + "," + str(
    #     gameState.getPacmanPosition()[1]) + "," + str(
    #     gameState.data.layout.width) + "," + str(
    #     gameState.data.layout.height) + "," + str(
    #     gameState.getLivingGhosts()[1]) + "," + str(
    #     gameState.getLivingGhosts()[2]) + "," + str(
    #     gameState.getLivingGhosts()[3]) + "," + str(
    #     gameState.getLivingGhosts()[4]) + "," + str(
    #     numpy.count_nonzero(gameState.getLivingGhosts())) + "," + str(
    #     gameState.getGhostPositions()[0][0]) + "," + str(
    #     gameState.getGhostPositions()[0][1]) + "," + str(
    #     gameState.getGhostPositions()[1][0]) + "," + str(
    #     gameState.getGhostPositions()[1][1]) + "," + str(
    #     gameState.getGhostPositions()[2][0]) + "," + str(
    #     gameState.getGhostPositions()[2][1]) + "," + str(
    #     gameState.getGhostPositions()[3][0]) + "," + str(
    #     gameState.getGhostPositions()[3][1]) + "," + str(
    #     -1 if gameState.data.ghostDistances[0] is None else gameState.data.ghostDistances[0]) + "," + str(
    #     -1 if gameState.data.ghostDistances[1] is None else gameState.data.ghostDistances[1]) + "," + str(
    #     -1 if gameState.data.ghostDistances[2] is None else gameState.data.ghostDistances[2]) + "," + str(
    #     -1 if gameState.data.ghostDistances[3] is None else gameState.data.ghostDistances[3]) + "," + str(
    #     min(x for x in gameState.data.ghostDistances if x is not None)) + "," + str(
    #     gameState.getScore()) + "," + str(
    #     gameState2.getScore()) + "," +  str(
    #     gameState.data.agentStates[0].getDirection())

class QLearningAgent(BustersAgent):
    """
      Q-Learning Agent

      Functions you should fill in:
        - update

      Instance variables you have access to
        - self.epsilon (exploration prob)
        - self.alpha (learning rate)
        - self.discount (discount rate)
    """
    def __init__(self, **args):
        "Initialize Q-values"
        BustersAgent.__init__(self, **args)
        self.numTraining = 100
        self.episodesSoFar = 0
        self.accumTrainRewards = 0.0

        self.actions = {"North":0, "South":1, "East":2, "West":3, "Stop":0}
        self.table_file = open("qtable.txt", "r+")
        self.q_table = self.readQtable()
        self.epsilon = 0.07
        self.alpha = 0.05
        self.discount = 0.05

    def readQtable(self):
        "Read qtable from disc"
        table = self.table_file.readlines()
        q_table = []

        for i, line in enumerate(table):
            row = line.split()
            row = [float(x) for x in row]
            q_table.append(row)

        return q_table

    def writeQtable(self):
        "Write qtable to disc"
        self.table_file.seek(0)
        self.table_file.truncate()
        for line in self.q_table:
            for item in line:
                self.table_file.write(str(item)+" ")
            self.table_file.write("\n")

    def printQtable(self):
        "Print qtable"
        for line in self.q_table:
            print(line)
        print("\n")

    def __del__(self):
        "Destructor. Invokation at the end of each episode"
        self.writeQtable()
        self.table_file.close()

    def computePosition(self, state):
        """
        Compute the row of the qtable for a given state.
        For instance, the state (3,1) is the row 7
        """
        return 96*self.computeNearestGhostDistance(state)+24*self.computePacManOrientation(state)+8*self.computeNearestDotDistance(state)+self.computeNearestGhostDirection(state)

    def computeNearestGhostDistance(self, state):  # Cerca 2 Medio 1 Lejos 0
        distance = min(x for x in state.data.ghostDistances if x is not None)
        if distance < 7:
            return 2
        elif distance < 15:
            return 1
        else:
            return 0

    def computePacManOrientation(self, state):  # Norte 0 Sur 1 Este 2 Oeste 3
        if Directions.NORTH == state.data.agentStates[0].getDirection():
            return 0
        elif Directions.SOUTH == state.data.agentStates[0].getDirection():
            return 1
        elif Directions.EAST == state.data.agentStates[0].getDirection():
            return 2
        elif Directions.WEST == state.data.agentStates[0].getDirection():
            return 3
        else:
            return 0

    def computeNearestDotDistance(self, state):  # Cerca 2 Medio 1 Lejos 0
        distance = state.getDistanceNearestFood()
        if distance is not None:
            if distance < 7:
                return 2
            elif distance < 15:
                return 1
            else:
                return 0
        else:
            return 0

    def computeNearestGhostDirection(self, state):  # Norte 0 Noreste 1 Este 2 Sureste 3 Sur 4 Suroeste 5 Oeste 6 Noroeste 7
        pos = 0
        minlocal = 999
        iteracion = 0
        alive_ghosts = state.getLivingGhosts()
        for index in state.data.ghostDistances:
            if index is not None and index < minlocal and alive_ghosts[iteracion+1] == True:
                minlocal = index
                pos = iteracion
            iteracion += 1

        position_ghost = state.getGhostPositions()[pos]
        ghost_x = position_ghost[0]
        ghost_y = position_ghost[1]

        pacman_x = state.getPacmanPosition()[0]
        pacman_y = state.getPacmanPosition()[1]

        if   pacman_x - ghost_x == 0 and pacman_y - ghost_y <  0: # Norte 0
            return  0
        elif pacman_x - ghost_x <  0 and pacman_y - ghost_y <  0: # Noreste 1
            return  1
        elif pacman_x - ghost_x <  0 and pacman_y - ghost_y == 0: # Este 2
            return  2
        elif pacman_x - ghost_x <  0 and pacman_y - ghost_y >  0: # Sureste 3
            return  3
        elif pacman_x - ghost_x == 0 and pacman_y - ghost_y >  0: # Sur 4
            return  4
        elif pacman_x - ghost_x >  0 and pacman_y - ghost_y >  0: # Suroeste 5
            return  5
        elif pacman_x - ghost_x >  0 and pacman_y - ghost_y == 0: # Oeste 6
            return  6
        elif pacman_x - ghost_x >  0 and pacman_y - ghost_y <  0: # Noroeste 7
            return  7

    def computePosition2(self, state):
        """
        Compute the row of the qtable for a given state.
        For instance, the state (3,1) is the row 7
        """
        return 96*self.computeNearestGhostDistance2(state)+48*self.nearWallUp(state)+24*self.nearWallDown(state)+12*self.nearWallLeft(state)+6*self.nearWallRight(state)+2*self.computeNearestDotDistance(state)+self.computeNearestGhostDirection2(state)

    def computeNearestGhostDistance2(self, state):  # Muy cerca 4 Cerca 3 Media 2 Lejos 1 Muy Lejos 0
        distance = min(x for x in state.data.ghostDistances if x is not None)
        if distance < 4:    # Muy cerca
            return 4
        elif distance < 7:  # Cerca
            return 3
        elif distance < 10: # Media
            return 2
        elif distance < 13: # Lejos
            return 1
        else:               # Muy Lejos
            return 0

    def nearWallUp(self,state):
        pos = state.getPacmanPosition()
        if state.hasWall(pos[0],pos[1]+1):
            return 1
        else:
            return 0

    def nearWallDown(self,state):
        pos = state.getPacmanPosition()
        if state.hasWall(pos[0],pos[1]-1):
            return 1
        else:
            return 0

    def nearWallLeft(self,state):
        pos = state.getPacmanPosition()
        if state.hasWall(pos[0]-1,pos[1]):
            return 1
        else:
            return 0

    def nearWallRight(self,state):
        pos = state.getPacmanPosition()
        if state.hasWall(pos[0]+1,pos[1]):
            return 1
        else:
            return 0

    def computeNearestGhostDirection2(self, state):   # Norte 0 Sur 1 Este 2 Oeste 3
        pos = 0
        minlocal = 999
        iteracion = 0
        alive_ghosts = state.getLivingGhosts()
        for index in state.data.ghostDistances:
            if index is not None and index < minlocal and alive_ghosts[iteracion+1] == True:
                minlocal = index
                pos = iteracion
            iteracion += 1

        position_ghost = state.getGhostPositions()[pos]
        ghost_x = position_ghost[0]
        ghost_y = position_ghost[1]

        pacman_x = state.getPacmanPosition()[0]
        pacman_y = state.getPacmanPosition()[1]

        dis_ejex = ghost_x-pacman_x
        dis_ejey = ghost_y-pacman_y

        if (abs(dis_ejex) > abs(dis_ejey)):
            return 1
        else:
            return 0

    def getQValue(self, state, action): # Norte 0 Sur 1 Este 2 Oeste 3

        """
          Returns Q(state,action)
          Should return 0.0 if we have never seen a state
          or the Q node value otherwise
        """
        position = self.computePosition2(state)

        action_column = self.actions[action]
        return self.q_table[position][action_column]


    def computeValueFromQValues(self, state):
        """
          Returns max_action Q(state,action)
          where the max is over legal actions.  Note that if
          there are no legal actions, which is the case at the
          terminal state, you should return a value of 0.0.
        """
        legalActions = state.getLegalActions(0)
        if len(legalActions)==0:
          return 0
        return max(self.q_table[self.computePosition2(state)])

    def computeActionFromQValues(self, state):
        """
          Compute the best action to take in a state.  Note that if there
          are no legal actions, which is the case at the terminal state,
          you should return None.
        """
        legalActions = state.getLegalActions(0)
        legalActions.remove('Stop')

        if len(legalActions)==0:
          return None

        best_actions = [legalActions[0]]
        best_value = self.getQValue(state, legalActions[0])
        for action in legalActions:
            value = self.getQValue(state, action)
            if value == best_value:
                best_actions.append(action)
            if value > best_value:
                best_actions = [action]
                best_value = value

        return random.choice(best_actions)

    def getAction(self, state):
        """
          Compute the action to take in the current state.  With
          probability self.epsilon, we should take a random action and
          take the best policy action otherwise.  Note that if there are
          no legal actions, which is the case at the terminal state, you
          should choose None as the action.
        """

        # Pick Action
        legalActions = state.getLegalActions(0)
        if Directions.STOP in legalActions:
            legalActions.remove('Stop')
        action = None
        self.lastState = state

        if len(legalActions) == 0:
            self.lastAction = action
            return action

        flip = util.flipCoin(self.epsilon)

        if flip:
            self.lastAction = random.choice(legalActions)
            return self.lastAction

        self.lastAction = self.getPolicy(state)
        return self.lastAction


    def update(self, state, action, nextState, reward):
        """
        The parent class calls this to observe a
        state = action => nextState and reward transition.
        You should do your Q-Value update here

        Good Terminal state -> reward 1
        Bad Terminal state -> reward -1
        Otherwise -> reward 0

        Q-Learning update:

        if terminal_state:
        Q(state,action) <- (1-self.alpha) Q(state,action) + self.alpha * (r + 0)
        else:
        Q(state,action) <- (1-self.alpha) Q(state,action) + self.alpha * (r + self.discount * max a' Q(nextState, a'))

        """
        # TRACE for transition and position to update. Comment the following lines if you do not want to see that trace
        # print("Update Q-table with transition:\n", state, action,"\n", nextState, reward)
        position = self.computePosition2(state)
        action_column = self.actions[action]

        # print("Corresponding Q-table cell to update:", position, action_column)

        "*** YOUR CODE HERE ***"
        self.q_table[position][action_column] = (1-self.alpha)*self.q_table[position][action_column] + self.alpha * (reward + self.discount * self.computeValueFromQValues(nextState))
        # TRACE for updated q-table. Comment the following lines if you do not want to see that trace
        # print("Q-table:")
        # self.printQtable()

    def getPolicy(self, state):
        "Return the best action in the qtable for a given state"
        return self.computeActionFromQValues(state)

    def getValue(self, state):
        "Return the highest q value for a given state"
        return self.computeValueFromQValues(state)

    def observeTransition(self, state,action,nextState,deltaReward):
        """
            Called by environment to inform agent that a transition has
            been observed. This will result in a call to self.update
            on the same arguments

            NOTE: Do *not* override or call this function
        """
        self.episodeRewards += deltaReward
        self.update(state,action,nextState,deltaReward)

    def observationFunction(self, state):
        """
            This is where we ended up after our last action.
            The simulation should somehow ensure this is called
        """
        if not self.lastState is None:
            reward = self.getReward2(self.lastState, state)
            print(reward)
            self.observeTransition(self.lastState, self.lastAction, state, reward)
        return state

    def getReward(self, state, nextstate):
        distance = min(x for x in nextstate.data.ghostDistances if x is not None)
        return self.sumaFantasma(state, nextstate)+self.sumaComida(state, nextstate)+self.sumaAcercarseF(state,nextstate)+self.sumaAcercarseC(state,nextstate)+self.sumaIrDireccionCorrecta(nextstate)-1-(distance*0.1)+self.choquePared(state)

    def sumaFantasma (self,state, nextState):
        if (nextState.getScore()-state.getScore ()) == 199:
            return 200
        else:
            return 0

    def sumaComida (self,state, nextState):
        if (nextState.getScore()-state.getScore ()) == 99:
            return 100
        else:
            return 0

    def sumaAcercarseF (self,state,nextstate): # Cerca 2 Medio 1 Lejos 0
        if self.computeNearestGhostDistance(state) == 0 and self.computeNearestGhostDistance(nextstate) ==1: #Lejos a medio
            return 3.5
        if self.computeNearestGhostDistance(state) == 1 and self.computeNearestGhostDistance(nextstate)==2: #Medio a cerca
            return 7
        if self.computeNearestGhostDistance(state) == 1 and self.computeNearestGhostDistance(nextstate)==0: #Medio a lejos
            return -1
        if self.computeNearestGhostDistance(state) == 2 and self.computeNearestGhostDistance(nextstate)==1: #Cerca a medio
            return -1.5
        else:
            return 0

    def sumaAcercarseF2(self,state,nextstate): # Muy Cerca: 4 Cerca 3 Medio 2 Lejos 1 Muy Lejos 0
        if self.computeNearestGhostDistance2(state) == 0 and self.computeNearestGhostDistance2(nextstate) ==1: #Muy Lejos a lejos
            return 1.25
        if self.computeNearestGhostDistance2(state) == 1 and self.computeNearestGhostDistance2(nextstate) ==2: #Lejos a medio
            return 2.5
        if self.computeNearestGhostDistance2(state) == 2 and self.computeNearestGhostDistance2(nextstate)==3: #Medio a cerca
            return 5
        if self.computeNearestGhostDistance2(state) == 3 and self.computeNearestGhostDistance2(nextstate)==4: #Cerca a Muy cerca
            return 10
        if self.computeNearestGhostDistance2(state) == 4 and self.computeNearestGhostDistance2(nextstate) ==3: #muy cerca a cerca
            return -20
        if self.computeNearestGhostDistance2(state) == 3 and self.computeNearestGhostDistance2(nextstate)==2: #Cerca a medio
            return -10
        if self.computeNearestGhostDistance2(state) == 2 and self.computeNearestGhostDistance2(nextstate)==1: #Medio a lejos
            return -5
        if self.computeNearestGhostDistance2(state) == 1 and self.computeNearestGhostDistance2(nextstate)==0: #Lejos a muy lejos
            return -2.5
        else:
            return 0

    def sumaAcercarseC (self,state,nextstate): # Cerca 2 Medio 1 Lejos 0
        if self.computeNearestDotDistance(state) == 0 and self.computeNearestDotDistance(nextstate) ==1: #Lejos a medio
            return 1.75
        if self.computeNearestDotDistance(state) == 1 and self.computeNearestDotDistance(nextstate)==2: #Medio a cerca
            return 3.5
        if self.computeNearestDotDistance(state) == 1 and self.computeNearestDotDistance(nextstate)==0: #Medio a lejos
            return -0.5
        if self.computeNearestDotDistance(state) == 2 and self.computeNearestDotDistance(nextstate)==1: #Cerca a medio
            return -0.75
        else:
            return 0

    def sumaIrDireccionCorrecta (self,state):
            # Norte 0 Sur 1 Este 2 Oeste 3
            # Norte 0 Noreste 1 Este 2 Sureste 3 Sur 4 Suroeste 5 Oeste 6 Noroeste 7
            if self.computePacManOrientation(state) == 0 and (self.computeNearestGhostDirection(state) == 0):
                return 1
            if self.computePacManOrientation(state) == 1 and (self.computeNearestGhostDirection(state) == 4):
                return 1
            if self.computePacManOrientation(state) == 2 and (self.computeNearestGhostDirection(state) == 2):
                return 1
            if self.computePacManOrientation(state) == 3 and (self.computeNearestGhostDirection(state) == 6):
                return 1
            return 0

    def choquePared (self,state):
        pos = state.getPacmanPosition()
        if (state.hasWall(pos[0]+1,pos[1]) == True) and (self.computeNearestGhostDirection(state) == 2 or self.computeNearestGhostDirection(state) == 3 or self.computeNearestGhostDirection(state) == 1):
            return -100
        if (state.hasWall(pos[0]-1,pos[1]) == True) and (self.computeNearestGhostDirection(state) == 5 or self.computeNearestGhostDirection(state) == 6 or self.computeNearestGhostDirection(state) == 7):
            return -100
        if (state.hasWall(pos[0],pos[1]+1) == True) and (self.computeNearestGhostDirection(state) == 0 or self.computeNearestGhostDirection(state) == 1 or self.computeNearestGhostDirection(state) == 7):
            return -100
        if (state.hasWall(pos[0],pos[1]-1) == True) and (self.computeNearestGhostDirection(state) == 3 or self.computeNearestGhostDirection(state) == 4 or self.computeNearestGhostDirection(state) == 5):
            return -100
        else:
            return 0

    def getReward2(self, state, nextstate):
        distance = min(x for x in nextstate.data.ghostDistances if x is not None)
        return self.sumaFantasma(state, nextstate)+self.sumaComida(state, nextstate)+self.sumaAcercarseF2(state,nextstate)+self.sumaAcercarseC(state,nextstate)+self.sumaIrDireccionCorrecta(nextstate)-1-(distance*0.1)+self.choquePared2(state)+self.avoidLoop(state, nextstate)

    def choquePared2 (self,state):
        pos = state.getPacmanPosition()
        ar = state.hasWall(pos[0],pos[1]+1)
        ab = state.hasWall(pos[0],pos[1]-1)
        d = state.hasWall(pos[0]+1,pos[1])
        i = state.hasWall(pos[0]-1,pos[1])
        ard = state.hasWall(pos[0]+1,pos[1]+1)
        ari = state.hasWall(pos[0]-1,pos[1]+1)
        abd = state.hasWall(pos[0]+1,pos[1]-1)
        abi = state.hasWall(pos[0]-1,pos[1]-1)
        ref = 0
        if (d == True) and (self.computeNearestGhostDirection(state) == 2 or self.computeNearestGhostDirection(state) == 3 or self.computeNearestGhostDirection(state) == 1):
            ref-=40
            if ard: ref-=40
            if abd: ref-=40
            if (ar and ab) or (i and ar) or (i and ab): ref-=40
        if (i == True) and (self.computeNearestGhostDirection(state) == 5 or self.computeNearestGhostDirection(state) == 6 or self.computeNearestGhostDirection(state) == 7):
            ref-=40
            if ari: ref-=40
            if abi: ref-=40
            if (ar and ab) or (d and ar) or (d and ab): ref-=40
        if (ar == True) and (self.computeNearestGhostDirection(state) == 0 or self.computeNearestGhostDirection(state) == 1 or self.computeNearestGhostDirection(state) == 7):
            ref-=40
            if ard: ref-=40
            if ari: ref-=40
            if (i and d) or (ab and d) or (ab and i): ref-=40
        if (ab == True) and (self.computeNearestGhostDirection(state) == 3 or self.computeNearestGhostDirection(state) == 4 or self.computeNearestGhostDirection(state) == 5):
            ref-=40
            if abd: ref-=40
            if abi: ref-=40
            if (i and d) or (ar and d) or (ar and i): ref-=40
        return ref

    def avoidLoop(self, state, nextState):
        dir = state.data.agentStates[0].getDirection()
        posactual = state.getPacmanPosition()
        posanterior = [posactual[0],posactual[1]]
        possiguiente = nextState.getPacmanPosition()


        if (dir == 'North'):
            posanterior[1] = posactual[1]-1
            posanterior [0] = posactual[0]
        elif (dir == 'South'):
            posanterior[1] = posactual[1]+1
            posanterior [0] = posactual[0]
        elif (dir == 'West'):
            posanterior[0] =posactual[0]+1
            posanterior [1] = posactual[1]
        elif dir == 'East':
            posanterior[0]= posactual[0]-1
            posanterior[1] = posactual[1]
        else:
            posanterior = posactual


        if posanterior[0]  == possiguiente[0] and posanterior[1]  == possiguiente[1]:
            return -40
        else:
            return 0

    def startEpisode(self):
        """
          Called by environment when new episode is starting
        """
        self.lastState = None
        self.lastAction = None
        self.episodeRewards = 0.0

    def registerInitialState(self, state):
        self.startEpisode()
        if self.episodesSoFar == 0:
            print('Beginning %d episodes of Training' % (self.numTraining))

    def stopEpisode(self):
        """
          Called by environment when episode is done
        """
        if self.episodesSoFar < self.numTraining:
            self.accumTrainRewards += self.episodeRewards
        else:
            self.accumTestRewards += self.episodeRewards
        self.episodesSoFar += 1
        if self.episodesSoFar >= self.numTraining:
            # Take off the training wheels
            self.epsilon = 0.0    # no exploration
            self.alpha = 0.0      # no learning

    def isInTraining(self):
        return self.episodesSoFar < self.numTraining

    def isInTesting(self):
        return not self.isInTraining()

    def final(self, state):
        """
          Called by Pacman game at the terminal state
        """
        print(state.getScore())


        deltaReward = state.getScore() - self.lastState.getScore()
        self.observeTransition(self.lastState, self.lastAction, state, deltaReward)
        self.stopEpisode()

        # Make sure we have this var
        if not 'episodeStartTime' in self.__dict__:
            self.episodeStartTime = time.time()
        if not 'lastWindowAccumRewards' in self.__dict__:
            self.lastWindowAccumRewards = 0.0
        self.lastWindowAccumRewards += state.getScore()

        NUM_EPS_UPDATE = 100
        if self.episodesSoFar % NUM_EPS_UPDATE == 0:
            print('Reinforcement Learning Status:')
            windowAvg = self.lastWindowAccumRewards / float(NUM_EPS_UPDATE)
            if self.episodesSoFar <= self.numTraining:
                trainAvg = self.accumTrainRewards / float(self.episodesSoFar)
                print('\tCompleted %d out of %d training episodes' % (
                       self.episodesSoFar,self.numTraining))
                print('\tAverage Rewards over all training: %.2f' % (
                        trainAvg))
            else:
                testAvg = float(self.accumTestRewards) / (self.episodesSoFar - self.numTraining)
                print('\tCompleted %d test episodes' % (self.episodesSoFar - self.numTraining))
                print('\tAverage Rewards over testing: %.2f' % testAvg)
            print('\tAverage Rewards for last %d episodes: %.2f'  % (
                    NUM_EPS_UPDATE,windowAvg))
            print('\tEpisode took %.2f seconds' % (time.time() - self.episodeStartTime))
            self.lastWindowAccumRewards = 0.0
            self.episodeStartTime = time.time()

        if self.episodesSoFar == self.numTraining:
            msg = 'Training Done (turning off epsilon and alpha)'
            print('%s\n%s' % (msg,'-' * len(msg)))
