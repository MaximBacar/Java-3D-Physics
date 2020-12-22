package pif.application;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import pif.engine.Render;

public class Application extends JFrame{
	
	private JPanel contentPane;
	
	Render renderer;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					
					
					Application frame = new Application();
					frame.getContentPane().setBackground(Color.black);
					frame.setVisible(true);
					
					
					//frame.setResizable(false);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
	
	public Application() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(1920/2 - 250, 1080/2 - 350, 1000, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		
		renderer = new Render();
		renderer.setBounds(0, 0, 1000, 1000);
		renderer.setLayout(null);
		renderer.setOpaque(false);
		contentPane.add(renderer);
		
		
		
		
		
	}

}
