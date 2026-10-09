class MainActivity : ComponentActivity() {
    private lateinit var keypad: Keypad
    
    override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		keypad = Keypad(getSystemService(INPUT_SERVICE) as InputManager)

		enableEdgeToEdge()
		setContent {
			CalculatorTheme {
				Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    // print the current tile name
					val layout = keypad.layout.collectAsState().value
					Text(modifier = Modifier.padding(innerPadding), text = "Current tile: $layout")

				}
			}
		}
	}

    override fun onResume() {
		super.onResume()
		keypad.listenForChanges()
	}

	override fun onPause() {
		super.onPause()
		keypad.stopListening()
	}
}