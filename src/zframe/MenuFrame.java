package zframe;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class MenuFrame {

	private JFrame frame;
	static AutoClicker clicker = new AutoClicker();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuFrame window = new MenuFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private int delay = 500;
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnStart = new JButton("開始");
		btnStart.setFont(new Font("新細明體", Font.PLAIN, 18));
		btnStart.setBounds(109, 212, 87, 23);
		frame.getContentPane().add(btnStart);
		
		JButton btnStop = new JButton("結束");
		btnStop.setFont(new Font("新細明體", Font.PLAIN, 18));
		btnStop.setBounds(211, 212, 87, 23);
		frame.getContentPane().add(btnStop);
		
		JSlider slider = new JSlider();
		slider.setPaintLabels(true);
		slider.setMaximum(1000);
		slider.setValue(500);
		slider.setPaintTicks(true);
		slider.setMinorTickSpacing(100);
		slider.setPaintTrack(true);
		slider.setMajorTickSpacing(100);
		slider.setBounds(10, 135, 414, 46);
		frame.getContentPane().add(slider);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 191, 434, 2);
		frame.getContentPane().add(separator);
		
		JLabel clickfq = new JLabel("按鍵頻率 (毫秒)");
		clickfq.setHorizontalAlignment(SwingConstants.CENTER);
		clickfq.setFont(new Font("新細明體", Font.PLAIN, 20));
		clickfq.setBounds(109, 72, 189, 36);
		frame.getContentPane().add(clickfq);
		
		JLabel lblNewLabel_1 = new JLabel("自動點擊器");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 30));
		lblNewLabel_1.setBounds(109, 10, 189, 69);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel cfq = new JLabel("500ms");
		cfq.setHorizontalAlignment(SwingConstants.CENTER);
		cfq.setFont(new Font("新細明體", Font.PLAIN, 18));
		cfq.setBounds(119, 110, 179, 23);
		frame.getContentPane().add(cfq);
		
		
		
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clicker.run = true;
				clicker.setDelay(delay);
				clicker.RunOnThread();
			}
		});
		
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clicker.run = false;
			}
		});
		
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				delay = slider.getValue();
				cfq.setText(String.valueOf(delay + "ms"));
				clicker.setDelay(delay);
			}
		});
	}
}
