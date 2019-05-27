package controller;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import model.GameFigure;

/**
 * QuadTree object.
 *
 * The quadrant indexes are numbered as below:
 *     |
 *  1  |  0
 * ----+----
 *  2  |  3
 *     |
 */

public class Quadtree {

	private int MAX_OBJECTS = 10;
	private int MAX_LEVELS = 5;

	private int level;
	private List<GameFigure> objects;
	private Rectangle2D bounds;
	private Quadtree[] nodes;

	/*
	 * Constructor
	 */
	public Quadtree(int pLevel, Rectangle2D pBounds) {
		level = pLevel;
		objects = new ArrayList<GameFigure>();
		bounds = pBounds;
		nodes = new Quadtree[4];
	}

	/**
	 * Clears the quadtree
	 */
	public void clear() {
		objects.clear();

		for (int i = 0; i < nodes.length; i++) {
			if (nodes[i] != null) {
				nodes[i].clear();
				nodes[i] = null;
			}
		}
	}

	/**
	 * Splits the node into 4 subnodes
	 */
	private void split() {
		int subWidth = (int) (bounds.getWidth() / 2);
		int subHeight = (int) (bounds.getHeight() / 2);
		int x = (int) bounds.getX();
		int y = (int) bounds.getY();

		nodes[0] = new Quadtree(level + 1, new Rectangle2D.Double(x + subWidth, y, subWidth, subHeight));
		nodes[1] = new Quadtree(level + 1, new Rectangle2D.Double(x, y, subWidth, subHeight));
		nodes[2] = new Quadtree(level + 1, new Rectangle2D.Double(x, y + subHeight, subWidth, subHeight));
		nodes[3] = new Quadtree(level + 1, new Rectangle2D.Double(x + subWidth, y + subHeight, subWidth, subHeight));
	}

	/**
	 * Determine which node the object belongs to. 
	 * -1 means object cannot completely fit within a child node and is part of the parent node
	 */
	private int getIndex(GameFigure pRect) {
		int index = -1;
		double x_AxisMidpoint = bounds.getX() + (bounds.getWidth() / 2);
		double y_AxisMidpoint = bounds.getY() + (bounds.getHeight() / 2);
		// Object can completely fit within the TOP quadrants
		boolean topQuadrant = (pRect.getCollisionBox().getY() < y_AxisMidpoint
				&& pRect.getCollisionBox().getY() + pRect.getCollisionBox().getHeight() < y_AxisMidpoint);
		// Object can completely fit within the BOTTOM quadrants
		boolean bottomQuadrant = (pRect.getCollisionBox().getY() > y_AxisMidpoint);

		// Object can completely fit within the LEFT quadrants
		if (pRect.getCollisionBox().getX() < x_AxisMidpoint
				&& pRect.getCollisionBox().getX() + pRect.getCollisionBox().getWidth() < x_AxisMidpoint) {
			if (topQuadrant) {
				index = 1;
			} else if (bottomQuadrant) {
				index = 2;
			}
		}
		// Object can completely fit within the RIGHT quadrants
		else if (pRect.getCollisionBox().getX() > x_AxisMidpoint) {
			if (topQuadrant) {
				index = 0;
			} else if (bottomQuadrant) {
				index = 3;
			}
		}

		return index;
	}

	/**
	 * Insert the object into the quadtree. If the node exceeds the capacity, it
	 * will split and add all objects to their corresponding nodes.
	 */
	public void insert(GameFigure pRect) {
		if (nodes[0] != null) { 
			int index = getIndex(pRect);

			if (index != -1) {
				nodes[index].insert(pRect);

				return;
			}
		}

		objects.add(pRect);

		if (objects.size() > MAX_OBJECTS && level < MAX_LEVELS) {
			if (nodes[0] == null) {
				split();
			}

			int i = 0;
			while (i < objects.size()) {
				int index = getIndex(objects.get(i));
				if (index != -1) {
					nodes[index].insert(objects.remove(i));
				} else {
					i++;
				}
			}
		}
	}

	/**
	 * Return all objects that could collide with the given object
	 */
	public List<GameFigure> retrieve(List<GameFigure> returnObjects, GameFigure pRect) {
		int index = getIndex(pRect);
		if (index != -1 && nodes[0] != null) {
			nodes[index].retrieve(returnObjects, pRect);
		}

		returnObjects.addAll(objects);

		return returnObjects;
	}

}