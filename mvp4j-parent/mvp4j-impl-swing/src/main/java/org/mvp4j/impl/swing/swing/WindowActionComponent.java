package org.mvp4j.impl.swing.swing;

import java.awt.Window;
import java.awt.event.*;

import org.mvp4j.adapter.*;

public class WindowActionComponent extends ActionComponent {

	private static final Class<?> DEFAULT_EVENT_TYPE = WindowListener.class;

	private Window window;
	private String eventAction;

	private WindowListener windowListener;
	private MouseListener mouseListener;
	private KeyListener keyListener;
	private ComponentListener componentListener;
	private ContainerListener containerListener;
	private FocusListener focusListener;
	private HierarchyBoundsListener hierarchyBoundsListener;
	private HierarchyListener hierarchyListener;

	@Override
	public void bind() {
		Class<?> eventType = actionBinding.getEventType();
		eventAction = actionBinding.getEventAction();

		if (eventType == null) {
			eventType = DEFAULT_EVENT_TYPE;
		}

		if (eventType == WindowListener.class) {
			windowListener = new WindowListener() {

				@Override
				public void windowOpened(WindowEvent event) {
					if (eventAction.equals("windowOpened") || eventAction.equals("")) {
						actionBinding.callAction(event);
					}
				}

				@Override
				public void windowIconified(WindowEvent event) {
					if (eventAction.equals("windowIconified") || eventAction.equals("")) {
						actionBinding.callAction(event);
					}
				}

				@Override
				public void windowDeiconified(WindowEvent event) {
					if (eventAction.equals("windowDeiconified") || eventAction.equals("")) {
						actionBinding.callAction(event);
					}
				}

				@Override
				public void windowDeactivated(WindowEvent event) {
					if (eventAction.equals("windowDeactivated") || eventAction.equals("")) {
						actionBinding.callAction(event);
					}
				}

				@Override
				public void windowClosing(WindowEvent event) {
					if (eventAction.equals("windowClosing") || eventAction.equals("")) {
						actionBinding.callAction(event);
					}
				}

				@Override
				public void windowClosed(WindowEvent event) {
					if (eventAction.equals("windowClosed") || eventAction.equals("")) {
						actionBinding.callAction(event);
					}
				}

				@Override
				public void windowActivated(WindowEvent event) {
					if (eventAction.equals("windowActivated") || eventAction.equals("")) {
						actionBinding.callAction(event);
					}
				}
			};

			window.addWindowListener(windowListener);
		} else if (eventType == MouseListener.class) {
			mouseListener = new MouseListener() {

				@Override
				public void mouseReleased(MouseEvent event) {
					if (eventAction.equals("mouseReleased") || eventAction.equals("")) {
						actionBinding.callAction(event);
					}
				}

				@Override
				public void mousePressed(MouseEvent event) {
					if (eventAction.equals("mousePressed") || eventAction.equals("")) {
						actionBinding.callAction(event);
					}
				}

				@Override
				public void mouseExited(MouseEvent event) {
					if (eventAction.equals("mouseExited") || eventAction.equals("")) {
						actionBinding.callAction(event);
					}
				}

				@Override
				public void mouseEntered(MouseEvent event) {
					if (eventAction.equals("mouseEntered") || eventAction.equals("")) {
						actionBinding.callAction(event);
					}
				}

				@Override
				public void mouseClicked(MouseEvent event) {
					if (eventAction.equals("mouseClicked") || eventAction.equals("")) {
						actionBinding.callAction(event);
					}
				}
			};
			window.addMouseListener(mouseListener);

		}

		else if (eventType == KeyListener.class) {
			keyListener = new KeyListener() {

				@Override
				public void keyTyped(KeyEvent event) {
					if (eventAction.equals("keyTyped") || eventAction.equals("")) {
						actionBinding.callAction(event);
					}
				}

				@Override
				public void keyReleased(KeyEvent event) {
					if (eventAction.equals("keyReleased") || eventAction.equals("")) {
						actionBinding.callAction(event);
					}
				}

				@Override
				public void keyPressed(KeyEvent event) {
					if (eventAction.equals("keyPressed") || eventAction.equals("")) {
						actionBinding.callAction(event);
					}
				}
			};

			window.addKeyListener(keyListener);
		} else if (eventType == ComponentListener.class) {
			componentListener = new ComponentListener() {

				@Override
				public void componentShown(ComponentEvent event) {
					if (eventAction.equals("componentShown") || eventAction.equals("")) {
						actionBinding.callAction(event);
					}
				}

				@Override
				public void componentResized(ComponentEvent event) {
					if (eventAction.equals("componentResized") || eventAction.equals("")) {
						actionBinding.callAction(event);
					}
				}

				@Override
				public void componentMoved(ComponentEvent event) {
					if (eventAction.equals("componentMoved") || eventAction.equals("")) {
						actionBinding.callAction(event);
					}
				}

				@Override
				public void componentHidden(ComponentEvent event) {
					if (eventAction.equals("componentHidden") || eventAction.equals("")) {
						actionBinding.callAction(event);
					}
				}
			};

			window.addComponentListener(componentListener);
		} else if (eventType == ContainerListener.class) {
			containerListener = new ContainerListener() {

				@Override
				public void componentRemoved(ContainerEvent event) {
					if (eventAction.equals("componentRemoved") || eventAction.equals("")) {
						actionBinding.callAction(event);
					}
				}

				@Override
				public void componentAdded(ContainerEvent event) {
					if (eventAction.equals("componentAdded") || eventAction.equals("")) {
						actionBinding.callAction(event);
					}
				}
			};

			window.addContainerListener(containerListener);
		} else if (eventType == FocusListener.class) {
			focusListener = new FocusListener() {

				@Override
				public void focusLost(FocusEvent event) {
					if (eventAction.equals("focusLost") || eventAction.equals("")) {
						actionBinding.callAction(event);
					}
				}

				@Override
				public void focusGained(FocusEvent event) {
					if (eventAction.equals("focusGained")) {
						actionBinding.callAction(event);
					}
				}
			};

			window.addFocusListener(focusListener);
		} else if (eventType == HierarchyBoundsListener.class) {
			hierarchyBoundsListener = new HierarchyBoundsListener() {

				@Override
				public void ancestorResized(HierarchyEvent event) {
					if (eventAction.equals("ancestorResized") || eventAction.equals("")) {
						actionBinding.callAction(event);
					}
				}

				@Override
				public void ancestorMoved(HierarchyEvent event) {
					if (eventAction.equals("ancestorMoved") || eventAction.equals("")) {
						actionBinding.callAction(event);
					}
				}
			};

			window.addHierarchyBoundsListener(hierarchyBoundsListener);
		} else if (eventType == HierarchyListener.class) {
			hierarchyListener = new HierarchyListener() {

				@Override
				public void hierarchyChanged(HierarchyEvent event) {
					if (eventAction.equals("hierarchyChanged") || eventAction.equals("")) {
						actionBinding.callAction(event);
					}
				}
			};

			window.addHierarchyListener(hierarchyListener);
		}
	}

	@Override
	public void unbind() {
		// TODO
	}

	@Override
	public void init(ActionBinding actionBinding) {
		super.init(actionBinding);
		window = (Window) actionBinding.getComponent();
	}
}
