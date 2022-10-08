// require('dotenv').config();

module.exports = {
    src_folders: ['tests'],
    page_objects_path: ["tests/pages"],
    test_workers: false,

    webdriver: {
        start_process: true,
        port: 9515,
        server_path: "node_modules/chromedriver/lib/chromedriver/chromedriver",
    },

    test_settings: {
        default: {
            desiredCapabilities: {
                browserName: 'chrome',
                chromeOptions: {
                    args: ['--headless']
                }
            }
        }
    }
};
